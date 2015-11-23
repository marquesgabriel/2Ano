package br.edu.ifpr.posfixa.exceptions;

public class StackNullException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackNullException(String err){
		super(err);
	}
}
