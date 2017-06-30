package com.lucas.lojajogosapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.service.ItensServiceInterface;

@RestController
@RequestMapping(value="/itens")
public class ItensResources {
	
	@Autowired
	private ItensServiceInterface itensService;
	
	@RequestMapping(value="/{user_id}/{jogo_id}/{quant}", method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@PathVariable("user_id") Long user_id, 
			@PathVariable("jogo_id") Long jogo_id, @PathVariable("quant") Long quant){
		Item itemSalvo = itensService.insereNoCarrinho(jogo_id, user_id, quant);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(itemSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(value="/{user_id}/{jogo_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarItemCarrinho(@PathVariable("user_id") Long user_id, 
			@PathVariable("jogo_id") Long jogo_id){
		itensService.deletaDoCarrinho(jogo_id, user_id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/carrinho/{carrinho_id}", method = RequestMethod.GET)
	public List<Item> listarItensCarrinho(@PathVariable("carrinho_id") Long carrinho_id){
		return itensService.listarItensCarrinho(carrinho_id);
	}
}
