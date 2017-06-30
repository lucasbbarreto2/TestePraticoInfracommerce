package com.lucas.lojajogosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucas.lojajogosapi.domain.Jogo;


public interface JogosRepositoryInterface extends JpaRepository<Jogo, Long>{
	
}
