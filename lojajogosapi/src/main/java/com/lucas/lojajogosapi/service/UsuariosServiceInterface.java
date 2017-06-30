package com.lucas.lojajogosapi.service;

import java.util.List;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Usuario;

public interface UsuariosServiceInterface {
	Usuario criar(Usuario usuario);
	List<Usuario> obterTodos();
	Usuario obterUsuarioId(Long user_id);
	Carrinho buscarCarrinhoUsuario(Long id);
	
}
