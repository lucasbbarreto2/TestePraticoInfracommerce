package com.lucas.lojajogosapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucas.lojajogosapi.domain.DetalhesErro;
import com.lucas.lojajogosapi.service.exceptions.JogoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(JogoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleJogoNaoEncontradoException
				(JogoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro("O Livro não pode ser encontrado", 404L, 
				System.currentTimeMillis(), "Tratamento pode ser encontrado em [link para 404]");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
