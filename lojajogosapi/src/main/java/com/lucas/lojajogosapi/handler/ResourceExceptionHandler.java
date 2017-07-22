package com.lucas.lojajogosapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucas.lojajogosapi.domain.DetalhesErro;
import com.lucas.lojajogosapi.service.exceptions.CarrinhoNaoEncontradoException;
import com.lucas.lojajogosapi.service.exceptions.JogoNaoEncontradoException;
import com.lucas.lojajogosapi.service.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(JogoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleJogoNaoEncontradoException
				(JogoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro("O Jogo não pode ser encontrado", 404L, 
				System.currentTimeMillis(), "Tratamento pode ser encontrado em [link para 404]");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CarrinhoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleCarrinhoNaoEncontradoException
				(CarrinhoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro("O carrinho não pode ser encontrado", 404L, 
				System.currentTimeMillis(), "Tratamento pode ser encontrado em [link para 404]");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException
				(UsuarioNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro("Usuário não pode ser encontrado", 404L, 
				System.currentTimeMillis(), "Tratamento pode ser encontrado em [link para 404]");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
}
