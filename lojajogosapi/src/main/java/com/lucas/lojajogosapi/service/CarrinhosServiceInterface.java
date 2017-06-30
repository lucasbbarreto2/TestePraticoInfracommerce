package com.lucas.lojajogosapi.service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;

public interface CarrinhosServiceInterface {
	
	Carrinho criar(Carrinho carrinho);
	Carrinho salvar(Carrinho carrinho);
	Carrinho obterPorId(Long id);
	Carrinho salvarItem(Item item);
	void deletarItem(Item item);
	
	
}
