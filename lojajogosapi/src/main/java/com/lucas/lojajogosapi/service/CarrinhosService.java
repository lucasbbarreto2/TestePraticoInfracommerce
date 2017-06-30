package com.lucas.lojajogosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.repository.CarrinhosRepositoryInterface;

@Service
public class CarrinhosService implements CarrinhosServiceInterface {

		@Autowired
		private CarrinhosRepositoryInterface carrinhosRepository;


		@Override
		public Carrinho obterPorId(Long id) {
			return carrinhosRepository.findOne(id);
		}

		@Override
		public Carrinho salvarItem(Item item) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deletarItem(Item item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Carrinho criar(Carrinho carrinho) {
			return carrinhosRepository.save(carrinho);
		}

		@Override
		public Carrinho salvar(Carrinho carrinho) {
			return carrinhosRepository.save(carrinho);
		}
		
		
}
