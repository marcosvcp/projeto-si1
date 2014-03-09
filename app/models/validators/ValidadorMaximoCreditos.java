package models.validators;

import models.PlanoDeCurso;

public class ValidadorMaximoCreditos implements ValidadorDePeriodo {

	@Override
	public boolean validaPeriodo(int creditos) {
		return creditos <= PlanoDeCurso.MAXIMO_CREDITOS;
	}

}
