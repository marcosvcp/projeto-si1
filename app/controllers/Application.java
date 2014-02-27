package controllers;

import java.util.ArrayList;
import java.util.List;

import managers.GerenciadorDeCadeiras;
import models.Cadeira;
import models.PlanoDeCurso;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static PlanoDeCurso plano;

	public static Result index() {
		if (plano == null) {
			PlanoDeCurso planoBD = new Finder<Long, PlanoDeCurso>(Long.class,
					PlanoDeCurso.class).findUnique();
			if (planoBD != null) {
				// se ja houver uma entidade salva no BD carrega ela
				plano = planoBD;
				List<Cadeira> cadeirasBD = new Finder<Long, Cadeira>(
						Long.class, Cadeira.class).all();
				plano.distribuiCadeiras(cadeirasBD);
			} else {
				plano = new PlanoDeCurso();
				plano.save();
				plano.distribuiCadeiras(new ArrayList<Cadeira>(
						GerenciadorDeCadeiras.getMapaDeCadeiras().values()));
				plano.update();
			}
		}
		return ok(views.html.index.render(plano));
	}

	public static Result addCadeira(String cadeira, int periodo)
			throws NumberFormatException, Exception {
		plano.addCadeira(cadeira, periodo);
		plano.save();
		return redirect(routes.Application.index());
	}

	public static Result remPeriodo(int periodo) {
		plano.removePeriodo(periodo);
		return redirect(routes.Application.index());
	}

	public static Result remCadeira(String cadeira) throws Exception {
		plano.removeCadeira(cadeira);
		return redirect(routes.Application.index());
	}
}
