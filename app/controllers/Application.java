package controllers;

import models.Cadeira;
import models.Periodo;
import models.PlanoDeCurso;
import models.exceptions.LimiteDeCreditosUltrapassadoException;
import models.validators.ValidadorMaximoCreditos;
import models.validators.ValidadorMaximoMinimoCreditos;
import models.validators.ValidadorMinimoCreditos;

import play.data.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import models.*;
import views.html.*;

public class Application extends Controller {

	static PlanoDeCurso plano;
	static User user;

	public static Result index() {
		if (plano == null) {
			if (!PlanoDeCurso.find.all().isEmpty()) {
				plano = PlanoDeCurso.find.all().get(0);
				plano.atualizaMapaCadeira(Cadeira.find.all());
			} else {
				plano = new PlanoDeCurso();
				plano.distribuiCaderas(Cadeira.find.all());
				plano.save();
			}
		}
		for (Periodo periodo : plano.getPeriodos()) {
			periodo.setValidador(new ValidadorMaximoCreditos());
		}
		plano.getPeriodo(PlanoDeCurso.ULTIMO_PERIODO).setValidador(
				new ValidadorMaximoMinimoCreditos());
		return ok(views.html.index.render(plano));
	}

	public static Result remCadeira(String cadeira) {
		plano.removeCadeira(cadeira);
		plano.update();
		return redirect(routes.Application.index());
	}
	public static Result addCadeira(String cadeira, int periodo)
			throws LimiteDeCreditosUltrapassadoException {
		plano.addCadeira(cadeira, periodo);
		plano.update();
		return redirect(routes.Application.index());
	}
	
	
	
	
	public static Result login() {
	    return ok(
	        login.render(Form.form(Login.class)));
	}
	
	public static class Login {

	    public String email;
	    public String password;
	    
	    public String validate() {
//		    if (User.authenticate(email, password) == null) {
//		      return "Invalid user or password";
//		    }
		    return null;
		}
	}
	
	public static Result logout() {
	    session().clear();
	    flash("success", "You've been logged out");
	    return redirect(
	        routes.Application.login()
	    );
	}
	
	public static Result authenticate() {
	    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	        return badRequest(login.render(loginForm));
	    } else {
	        session().clear();
	        session("email", loginForm.get().email);
	        return redirect(
	            routes.Application.index()
	        );
	    }
	}
	
	
	
	
	
	
	
	
}