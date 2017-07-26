package com.lucas.lojajogosapi.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Carrinho>> listar(){
		CacheControl cache = CacheControl.maxAge(1, TimeUnit.MINUTES);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(carrinhosService.obterTodos());
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listarCarrinhoUsuario(@PathVariable("id") Long id){
		Carrinho carrinho = carrinhosService.obterPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(carrinho);
	}
	
	@RequestMapping(value="/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> criarCarrinhoUsuario(@PathVariable("user_id") Long user_id){
		Carrinho carrinhoCriado = carrinhosService.criar(user_id);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(carrinhoCriado.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
