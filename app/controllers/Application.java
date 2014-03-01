package controllers;

import models.Cadeira;
import models.PlanoDeCurso;
import models.exceptions.LimiteDeCreditosUltrapassadoException;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static PlanoDeCurso plano;

	public static Result index() {
		if (plano == null) {
			if (!PlanoDeCurso.find.all().isEmpty()) {
				plano = PlanoDeCurso.find.all().get(0);
				plano.atualizaMapaCadeira(plano.getCadeirasAlocadas());
			} else {
				plano = new PlanoDeCurso();
				plano.distribuiCaderas(Cadeira.find.all());
				plano.save();
			}
		}
		return ok(views.html.index.render(plano));
	}

	public static Result addCadeira(String cadeira, int periodo)
			throws LimiteDeCreditosUltrapassadoException {
		plano.addCadeira(cadeira, periodo);
		plano.update();
		return redirect(routes.Application.index());
	}
}