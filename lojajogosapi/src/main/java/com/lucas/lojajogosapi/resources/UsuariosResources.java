package com.lucas.lojajogosapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.service.UsuariosServiceInterface;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResources {

	@Autowired
	private UsuariosServiceInterface usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar(){
		return usuarioService.obterTodos();
	}
	
	@RequestMapping(value="/{user_id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable("user_id") Long user_id){
		Usuario usuario = usuarioService.obterUsuarioId(user_id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criarUsuario(@Valid @RequestBody Usuario user){
		
		Usuario usuario = usuarioService.criar(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/carrinho/{user_id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarCarrinhoUsuario(@PathVariable("user_id") Long user_id){
		Carrinho carrinho = usuarioService.buscarCarrinhoUsuario(user_id);
		return ResponseEntity.status(HttpStatus.OK).body(carrinho);
	}
}
