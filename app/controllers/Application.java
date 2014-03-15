package controllers;

import models.Cadeira;
import models.Periodo;
import models.PlanoDeCurso;
import models.exceptions.LimiteDeCreditosUltrapassadoException;
import models.validators.ValidadorMaximoCreditos;
import models.validators.ValidadorMaximoMinimoCreditos;
import models.validators.ValidadorMinimoCreditos;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static PlanoDeCurso plano;

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
}