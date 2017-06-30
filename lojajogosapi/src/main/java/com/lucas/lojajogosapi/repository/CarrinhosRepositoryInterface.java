package com.lucas.lojajogosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucas.lojajogosapi.domain.Carrinho;

public interface CarrinhosRepositoryInterface extends JpaRepository<Carrinho, Long>{
	
	
}
