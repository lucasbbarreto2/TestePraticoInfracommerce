package com.lucas.lojajogosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.domain.Jogo;

public interface ItemRepositoryInterface extends JpaRepository<Item, Long>{
	List<Item> findByCarrinho(Carrinho carrinho);
	Item findByCarrinhoAndProduto(Carrinho carrinho, Jogo produto);
}
