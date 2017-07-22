package com.lucas.lojajogosapi.service.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2050324548094450352L;
	
	public UsuarioNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public UsuarioNaoEncontradoException(String mensagem, Throwable problema){
		super(mensagem, problema);
	}
}
