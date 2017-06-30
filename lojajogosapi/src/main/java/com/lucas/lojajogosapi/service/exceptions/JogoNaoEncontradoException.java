package com.lucas.lojajogosapi.service.exceptions;

public class JogoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2065387629883794695L;
	
	public JogoNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public JogoNaoEncontradoException(String mensagem, Throwable problema){
		super(mensagem, problema);
	}
}
