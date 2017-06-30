package com.lucas.lojajogosapi.service;

import java.util.List;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;

public interface CarrinhosServiceInterface {
	
	Carrinho criar(Long user_id);
	Carrinho salvar(Carrinho carrinho);
	Carrinho obterPorId(Long id);
	Carrinho salvarItem(Item item);
	void deletarItem(Item item);
	List<Carrinho> obterTodos();
	
}
