package com.lucas.lojajogosapi.service.exceptions;

public class UsuarioJaExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3583190320569168204L;

	public UsuarioJaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioJaExistenteException(String message) {
		super(message);
	}

}
