package com.lucas.lojajogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.domain.Jogo;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.repository.ItemRepositoryInterface;
import com.lucas.lojajogosapi.service.exceptions.JogoNaoEncontradoException;

@Service
public class ItensService implements ItensServiceInterface {

	@Autowired
	private ItemRepositoryInterface itensRepository;
	
	@Autowired
	private CarrinhosServiceInterface carrinhoService;
	
	@Autowired
	private JogosServiceInterface jogoService;
	
	@Autowired
	private UsuariosServiceInterface usuarioService;
	
	
	@Override
	public Item insereNoCarrinho(Long jogo_id, Long user_id, Long quant) {
		Jogo jogo = jogoService.obterPorId(jogo_id);
		Usuario usuario = usuarioService.obterUsuarioId(user_id);
		Carrinho carrinho = carrinhoService.obterPorId(usuario.getCarrinho().getId());
		Item itemNoCarrinho = itensRepository.findByCarrinhoAndProduto(carrinho, jogo);
		try{
			if( itemNoCarrinho == null){
				Item item = new Item(jogo,quant, carrinho);		
				return itensRepository.save(item);
			}else{
				itemNoCarrinho.setQuantidade(quant+itemNoCarrinho.getQuantidade());
				return itensRepository.save(itemNoCarrinho);
			}
		}finally{
			atualizaTotalCarrinho(carrinho);
		}
	}
	
	private void atualizaTotalCarrinho(Carrinho carrinho){
		List<Item> listaDeItensNoCarrinho = itensRepository.findByCarrinho(carrinho);
		Double valorTotalCarrinho = 0.0;
		for(Item itens : listaDeItensNoCarrinho){
			valorTotalCarrinho += itens.getSubTotal();
		}
		carrinho.setTotal(valorTotalCarrinho);
		carrinhoService.salvar(carrinho);
	}

	@Override
	public void deletaDoCarrinho(Long jogo_id, Long user_id) {
		Jogo jogo = jogoService.obterPorId(jogo_id);
		Usuario usuario = usuarioService.obterUsuarioId(user_id);
		Carrinho carrinho = carrinhoService.obterPorId(usuario.getCarrinho().getId());
		try{
			itensRepository.deleteByCarrinhoAndProduto(carrinho, jogo);
		}catch(EmptyResultDataAccessException e){
			throw new JogoNaoEncontradoException("Jogo "+jogo_id+" não encontrado no carrinho do usuário"+user_id);
		}	
		
	}

	@Override
	public List<Item> listarItensCarrinho(Long carrinho_id) {
		Carrinho carrinho = carrinhoService.obterPorId(carrinho_id);
		return itensRepository.findByCarrinho(carrinho);
	}

}
