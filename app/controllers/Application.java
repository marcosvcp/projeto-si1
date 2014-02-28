package controllers;

import java.util.List;

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
				plano = new PlanoDeCurso(true);
				plano.save();
				plano.update();
			}
		}
		return ok(views.html.index.render(plano));
	}

	public static Result addCadeira(String cadeira, int periodo)
			throws NumberFormatException, Exception {
		plano.transfereCadeira(cadeira, periodo);
		plano.update();
		plano.save();
		return redirect(routes.Application.index());
	}
}
