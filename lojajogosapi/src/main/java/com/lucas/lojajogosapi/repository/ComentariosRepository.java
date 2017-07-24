package com.lucas.lojajogosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.lojajogosapi.domain.Comentarios;
import com.lucas.lojajogosapi.domain.Jogo;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{
	List<Comentarios> findByJogo(Jogo jogo);
}
