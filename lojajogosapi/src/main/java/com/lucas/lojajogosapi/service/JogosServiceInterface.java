package com.lucas.lojajogosapi.service;

import java.util.List;

import com.lucas.lojajogosapi.domain.Jogo;

public interface JogosServiceInterface {
	
	List<Jogo> obterTodos();
	Jogo salvar(Jogo jogo);
	Jogo obterPorId(Long id);
	void deletarPorId(Long id);
	void atualizar(Jogo jogo);

}
