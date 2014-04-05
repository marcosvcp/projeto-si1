package models.validators;

public class ValidadorDeCreditos implements ValidadorDePeriodo {
	private ValidadorDePeriodo validadorMaximoCreditos;
	private ValidadorDePeriodo validadorMinimoCreditos;

	public ValidadorDeCreditos() {
		this.validadorMaximoCreditos = new ValidadorMaximoCreditos();
		this.validadorMinimoCreditos = new ValidadorMinimoCreditos();
	}

	@Override
	public boolean validaPeriodo(int creditos) {
		return validadorMaximoCreditos.validaPeriodo(creditos)
				&& validadorMinimoCreditos.validaPeriodo(creditos);
	}

}
