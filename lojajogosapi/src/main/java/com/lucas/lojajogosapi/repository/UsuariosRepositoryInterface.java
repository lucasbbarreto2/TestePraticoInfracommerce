package com.lucas.lojajogosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.lojajogosapi.domain.Usuario;

public interface UsuariosRepositoryInterface extends JpaRepository<Usuario, Long>{
	
}
