package com.lucas.lojajogosapi.service.exceptions;

public class CarrinhoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2255176753070801877L;
	
	public CarrinhoNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public CarrinhoNaoEncontradoException(String mensagem, Throwable problema){
		super(mensagem, problema);
	}
}
