package com.lucas.lojajogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.repository.CarrinhosRepositoryInterface;
import com.lucas.lojajogosapi.repository.UsuariosRepositoryInterface;
import com.lucas.lojajogosapi.service.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuariosService implements UsuariosServiceInterface{
	
	@Autowired
	private UsuariosRepositoryInterface usuariosRepository;
	
	@Autowired
	private CarrinhosRepositoryInterface carrinhosRepository;
	
	@Override
	public Usuario criar(Usuario usuario) {
		return usuariosRepository.save(usuario);
	}

	@Override
	public List<Usuario> obterTodos() {
		return usuariosRepository.findAll();
	}

	@Override
	public Usuario obterUsuarioId(Long user_id) {
	
		return verificaExistencia(user_id);
	}

	@Override
	public Carrinho buscarCarrinhoUsuario(Long id) {
		
		Usuario usuario = verificaExistencia(id);
		return carrinhosRepository.findOne(usuario.getCarrinho().getId());
	}
	
	private Usuario verificaExistencia(Long user_id) throws UsuarioNaoEncontradoException{
		Usuario usuario = usuariosRepository.findOne(user_id);
		if(usuario==null)
			throw new UsuarioNaoEncontradoException("Usuario "+user_id+" não encontrado");
		
		return usuario;
	}
	
	
}
