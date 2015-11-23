package br.edu.ifpr.posfixa.exceptions;

public class StackEmptyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException(String err){
		super(err);
	}
}
