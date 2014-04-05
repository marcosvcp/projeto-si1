package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cadeira;
import models.Periodo;
import models.PlanoDeCurso;
import models.PlanoDeCurso.TipoPlano;
import models.User;
import models.exceptions.LimiteDeCreditosUltrapassadoException;
import models.validators.ValidadorMaximoCreditos;
import models.validators.ValidadorMaximoMinimoCreditos;
import play.data.Form;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Expr;
import com.google.common.base.Objects;

public class Application extends Controller {

	static PlanoDeCurso plano;

	public static Result index() {
		// Caso exista alguém logado
		if (session("plano_ID") == null) {
			return redirect(routes.Application.login());
		}
		// Pega o plano da seção e carrega do Bd
		User usuarioLogad = User.findByEmail(session("email"));
		plano = PlanoDeCurso.find.byId(Long.parseLong(session("plano_ID")));
		if (plano == null) {
			plano = new PlanoDeCurso();
			plano.distribuiCadeiras(Cadeira.findByType(usuarioLogad
					.getTipoPlano().getNomeTipo()));
			plano.setPeriodoAtual(1);
		}
		// Seta os validadores
		plano.atualizaMapaCadeira(Cadeira.findByType(usuarioLogad
				.getTipoPlano().getNomeTipo()));
		plano.atualizaValidadores();
		plano.getPeriodo(PlanoDeCurso.ULTIMO_PERIODO).setValidador(
				new ValidadorMaximoMinimoCreditos());
		plano.save();
		User user = User.findByEmail(session("email"));
		return ok(views.html.index.render(plano, user));
	}

	public static Result remCadeira(String cadeira)
			throws LimiteDeCreditosUltrapassadoException {
		plano.removeCadeira(cadeira);
		plano.save();
		return redirect(routes.Application.index());
	}

	public static Result addCadeira(String cadeira, int periodo)
			throws LimiteDeCreditosUltrapassadoException {
		plano.addCadeira(cadeira, periodo);
		plano.save();
		return redirect(routes.Application.index());
	}

	public static Result login() {
		return ok(views.html.login.render(Form.form(Login.class)));
	}

	public static Result cadastroPage() {
		return ok(views.html.cadastro.render(Form.form(Cadastro.class)));
	}

	public static Result mostraPlanosDosUsuarios() {
		return ok(views.html.redesocial.render(User.findAll()));
	}

	public static Result mostraGradeUsuario(String email) {
		User u = User.findByEmail(email);
		if (u == null) {
			return Application.mostraPlanosDosUsuarios();
		}
		if (u.getPlano() == null) {
			PlanoDeCurso plano = new PlanoDeCurso();
			plano.distribuiCadeiras(Cadeira.findByType(u.getTipoPlano()
					.getNomeTipo()));
			u.setPlano(plano);
			u.save();
		}
		return ok(views.html.gradeusuario.render(u));

	}

	public static class Login {

		public String email;
		public String password;

	}

	public static class Cadastro {
		public String email;
		public String password;
		public String nome;
		public int periodo;
	}

	public static Result logout() {
		session().clear();
		flash("success", "Você saiu do sistema!");
		return redirect(routes.Application.login());
	}

	public static Result cadastro() {
		Form<Cadastro> cadastroForm = Form.form(Cadastro.class)
				.bindFromRequest();
		if (cadastroForm.hasErrors()) {
			return badRequest(views.html.cadastro.render(cadastroForm));
		} else {
			User newUser = new User();
			newUser.setEmail(cadastroForm.get().email);
			newUser.setPassword(cadastroForm.get().password);
			newUser.setName(cadastroForm.get().nome);
			newUser.setTipoPlano(TipoPlano.Comum);
			PlanoDeCurso newPlano = new PlanoDeCurso();
			newPlano.distribuiCadeiras(Cadeira.findByType(newUser
					.getTipoPlano().getNomeTipo()));
			newUser.setPlano(newPlano);
			newPlano.save();
			newUser.save();
			return redirect(routes.Application.login());
		}
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors() || autenticacaoFalhou(loginForm)) {
			return badRequest(views.html.login.render(loginForm));
		} else {
			session().clear();
			User user = User.findByEmail(loginForm.get().email);
			if (user.getPlano() == null) {
				criaPlanoParaUsuario(user);
			}
			session("plano_ID", String.valueOf(user.getPlano().getId()));
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	private static void criaPlanoParaUsuario(User user) {
		PlanoDeCurso newPlano = new PlanoDeCurso();
		newPlano.distribuiCadeiras(Cadeira.findByType(user.getTipoPlano()
				.getNomeTipo()));
		user.setPlano(newPlano);
		user.save();
		newPlano.update();
	}

	private static boolean autenticacaoFalhou(Form<Login> loginForm) {
		User user = User.findByEmail(loginForm.get().email);
		if (user == null) {
			flash("success", "Email não cadastrado");
			return true;
		}
		if (!isPasswordValido(loginForm, user)) {
			flash("success", "Senha incorreta");
			return true;
		}
		return false;
	}

	public static Result atualizaPeriodo() {
		Form<Cadastro> cadastroForm = Form.form(Cadastro.class)
				.bindFromRequest();
		int periodo = cadastroForm.get().periodo;
		if (!(periodo < 1 || periodo > 10)) {
			plano.setPeriodoAtual(periodo);
			plano.update();
		}
		return index();
	}

	private static boolean isPasswordValido(Form<Login> loginForm, User user) {
		return String.valueOf(
				Objects.hashCode(user.getEmail(), loginForm.get().password))
				.equals(user.getPassword());
	}

	public static Result pesquisa() {
		DynamicForm df = new DynamicForm().bindFromRequest();
		String nome = df.get("nome");
		List<User> listaUsuarios = User.findAll();
		List<User> users = new ArrayList<User>();

		for (User usuario : listaUsuarios) {
			if (usuario.getName().toLowerCase().contains(nome.toLowerCase())) {
				users.add(usuario);
			}
		}
		return ok(views.html.redesocial.render(users));

	}
}