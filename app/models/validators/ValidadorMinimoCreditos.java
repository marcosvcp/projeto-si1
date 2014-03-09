package models.validators;

import models.PlanoDeCurso;

public class ValidadorMinimoCreditos implements ValidadorDePeriodo {

	@Override
	public boolean validaPeriodo(int creditos) {
		return creditos >= PlanoDeCurso.MINIMO_CREDITOS;
	}

}
