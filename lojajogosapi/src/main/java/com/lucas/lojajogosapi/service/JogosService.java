package com.lucas.lojajogosapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Comentarios;
import com.lucas.lojajogosapi.domain.Jogo;
import com.lucas.lojajogosapi.repository.ComentariosRepository;
import com.lucas.lojajogosapi.repository.JogosRepositoryInterface;
import com.lucas.lojajogosapi.service.exceptions.JogoNaoEncontradoException;

@Service
public class JogosService implements JogosServiceInterface {

	@Autowired
	private JogosRepositoryInterface jogosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	@Override
	public List<Jogo> obterTodos() {
		return jogosRepository.findAll();
	}

	@Override
	public Jogo salvar(Jogo jogo) {
		jogo.setId(null);
		return jogosRepository.save(jogo);
	}

	@Override
	public Jogo obterPorId(Long id) throws JogoNaoEncontradoException{
		
		Jogo jogo = jogosRepository.findOne(id); 
		
		if(jogo == null) 
			throw new JogoNaoEncontradoException("Jogo de ID "+id+" não encontrado");
		
		return jogo;
	}

	@Override
	public void deletarPorId(Long id) throws JogoNaoEncontradoException{
		try{
			jogosRepository.delete(id);
		}catch(EmptyResultDataAccessException e){
			throw new JogoNaoEncontradoException("Jogo de ID "+id+" não encontrado");
		}	
		
	}

	@Override
	public void atualizar(Jogo jogo) {
		verificaExistencia(jogo);
		jogosRepository.save(jogo);
	}
	
	private void verificaExistencia(Jogo jogo){
		obterPorId(jogo.getId());
	}
	
	@Override
	public Comentarios inserirComentarios(Long jogo_id, Comentarios comentario){
		Jogo jogo = obterPorId(jogo_id);
		comentario.setJogo(jogo);
		comentario.setData(LocalDateTime.now());
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentarios> buscarComentarios(Long jogo_id){
		Jogo jogo = obterPorId(jogo_id);
		return comentariosRepository.findByJogo(jogo);
	}
}
