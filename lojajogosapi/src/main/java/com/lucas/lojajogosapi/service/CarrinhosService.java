package com.lucas.lojajogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.repository.CarrinhosRepositoryInterface;
import com.lucas.lojajogosapi.service.exceptions.CarrinhoNaoEncontradoException;
import com.lucas.lojajogosapi.service.exceptions.UsuarioNaoEncontradoException;

@Service
public class CarrinhosService implements CarrinhosServiceInterface {

		@Autowired
		private CarrinhosRepositoryInterface carrinhosRepository;
		
		@Autowired
		private UsuariosServiceInterface usuariosService;


		@Override
		public Carrinho obterPorId(Long id) {
			return verificaExistencia(id);
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
			
			Carrinho carrinho = new Carrinho(verificaExistenciaUsuario(user_id));
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
		
		private Usuario verificaExistenciaUsuario(Long user_id) throws UsuarioNaoEncontradoException{
			Usuario usuario = usuariosService.obterUsuarioId(user_id);
			if(usuario == null)
				throw new UsuarioNaoEncontradoException("Usuario "+user_id+" não encontrado");
			return usuario;
		}
		
		private Carrinho verificaExistencia(Long carr_id){
			Carrinho carrinho = carrinhosRepository.findOne(carr_id);
			if(carrinho == null)
				throw new CarrinhoNaoEncontradoException("carrinho "+carr_id+" não encontrado ");
			
			return carrinho;
			
		}
		
}
