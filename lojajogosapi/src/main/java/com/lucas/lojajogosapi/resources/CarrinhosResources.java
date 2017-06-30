package com.lucas.lojajogosapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.service.CarrinhosServiceInterface;

@RestController
@RequestMapping(value = "/carrinhos")
public class  CarrinhosResources{
	
	@Autowired
	private CarrinhosServiceInterface carrinhosService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listarCarrinhoUsuario(@PathVariable("id") Long id){
		Carrinho carrinho = carrinhosService.obterPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(carrinho);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criarCarrinhoUsuario(@RequestBody Carrinho carrinho){
		Carrinho carrinhoCriado = carrinhosService.criar(carrinho);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(carrinhoCriado.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
