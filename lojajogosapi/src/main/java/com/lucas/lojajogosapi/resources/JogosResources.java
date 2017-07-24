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

import com.lucas.lojajogosapi.domain.Comentarios;
import com.lucas.lojajogosapi.domain.Jogo;
import com.lucas.lojajogosapi.service.JogosServiceInterface;

@RestController
@RequestMapping(value = "/jogos")
public class JogosResources {
	
	@Autowired
	private JogosServiceInterface jogosService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Jogo> listar(){
		return jogosService.obterTodos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Jogo jogo){
		Jogo jogoSalvo = jogosService.salvar(jogo);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(jogoSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
		
		Jogo jogo = jogosService.obterPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(jogo);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id ){
		
		jogosService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Jogo jogo, 
			@PathVariable("id") Long id){
		
		jogo.setId(id);
		jogosService.atualizar(jogo);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{jogo_id}/comentarios", method=RequestMethod.POST)
	public ResponseEntity<Void> inserirComentario(@PathVariable("jogo_id") Long jogo_id, 
			@RequestBody Comentarios comentario){
		jogosService.inserirComentarios(jogo_id, comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{jogo_id}/comentarios", method=RequestMethod.GET)
	public ResponseEntity<?> buscarComentarios(@PathVariable Long jogo_id){
		List<Comentarios> comentarios = jogosService.buscarComentarios(jogo_id);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}
