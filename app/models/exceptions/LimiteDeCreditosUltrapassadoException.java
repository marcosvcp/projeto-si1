package models.exceptions;

public class LimiteDeCreditosUltrapassadoException extends Exception{
	private static final long serialVersionUID = 1L;

	public LimiteDeCreditosUltrapassadoException(String message){
		super(message);
	}
	
	public String toString(){
		return this.getMessage();
	}
}
