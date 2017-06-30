package com.lucas.lojajogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.repository.CarrinhosRepositoryInterface;

@Service
public class CarrinhosService implements CarrinhosServiceInterface {

		@Autowired
		private CarrinhosRepositoryInterface carrinhosRepository;
		
		@Autowired
		private UsuariosServiceInterface usuariosService;


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
		public Carrinho criar(Long user_id) {
			Usuario usuario = usuariosService.obterUsuarioId(user_id);
			if(usuario == null)
				throw new NullPointerException("Usuario "+user_id+" não encontrado");
			Carrinho carrinho = new Carrinho(usuario);
			return carrinhosRepository.save(carrinho);
		}

		@Override
		public Carrinho salvar(Carrinho carrinho) {
			return carrinhosRepository.save(carrinho);
		}

		@Override
		public List<Carrinho> obterTodos() {
			return carrinhosRepository.findAll();
		}
		
		
}
