package br.fateczl.les.amigosecreto.service;

public class NegocioException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Construtor que enviara a mensagem de excessão
	public NegocioException(String message){
		super(message);
	}

}
