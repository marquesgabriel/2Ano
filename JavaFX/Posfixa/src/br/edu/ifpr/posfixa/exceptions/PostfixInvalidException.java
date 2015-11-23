package br.edu.ifpr.posfixa.exceptions;

public class PostfixInvalidException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostfixInvalidException(String err){
		super(err);
	}

}
