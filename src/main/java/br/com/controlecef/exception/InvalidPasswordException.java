package br.com.controlecef.exception;

public class InvalidPasswordException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
		
	}

	public InvalidPasswordException(Throwable t){
		super(t);
	}
	
	public InvalidPasswordException(String msg){
		super(msg);
	}
	

}
