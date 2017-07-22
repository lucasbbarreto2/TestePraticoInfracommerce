package com.lucas.lojajogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.lojajogosapi.domain.Carrinho;
import com.lucas.lojajogosapi.domain.Item;
import com.lucas.lojajogosapi.domain.Jogo;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.repository.ItemRepositoryInterface;
import com.lucas.lojajogosapi.service.exceptions.CarrinhoNaoEncontradoException;
import com.lucas.lojajogosapi.service.exceptions.JogoNaoEncontradoException;
import com.lucas.lojajogosapi.service.exceptions.UsuarioNaoEncontradoException;

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
		if(jogo == null)
			throw new JogoNaoEncontradoException("Jogo "+jogo_id+" não encontrado "); 
		
		Usuario usuario = usuarioService.obterUsuarioId(user_id);
		if(usuario == null)
			throw new UsuarioNaoEncontradoException("usuario "+user_id+" não encontrado "); 
		
		Carrinho carrinho = carrinhoService.obterPorId(usuario.getCarrinho().getId());
		if(carrinho == null)
			throw new CarrinhoNaoEncontradoException("carrinho "+usuario.getCarrinho().getId()+" não encontrado "); 
		
		Item itemNoCarrinho = retornaItemNoCarrinho(jogo_id, user_id);
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
	
	private Item retornaItemNoCarrinho(Long jogo_id, Long user_id){
		Jogo jogo = jogoService.obterPorId(jogo_id);
		if(jogo == null)
			throw new NullPointerException("Jogo "+jogo_id+" não encontrado "); 
		
		Usuario usuario = usuarioService.obterUsuarioId(user_id);
		if(usuario == null)
			throw new UsuarioNaoEncontradoException("usuario "+user_id+" não encontrado "); 
		
		Carrinho carrinho = carrinhoService.obterPorId(usuario.getCarrinho().getId());
		if(carrinho == null)
			throw new CarrinhoNaoEncontradoException("carrinho "+usuario.getCarrinho().getId()+" não encontrado ");
		
		return itensRepository.findByCarrinhoAndProduto(carrinho, jogo);
	}

	@Override
	public void deletaDoCarrinho(Long jogo_id, Long user_id) {
		Item itemNoCarrinho = retornaItemNoCarrinho(jogo_id, user_id);
		System.out.println(itemNoCarrinho.getId());
		try{
			itensRepository.delete(itemNoCarrinho.getId());
		}catch(Exception e){
			throw new JogoNaoEncontradoException("Jogo "+jogo_id+" não encontrado no carrinho do usuário"+user_id);
		}	
		
	}

	@Override
	public List<Item> listarItensCarrinho(Long carrinho_id) {
		Carrinho carrinho = carrinhoService.obterPorId(carrinho_id);
		if(carrinho == null)
			throw new NullPointerException("carrinho "+carrinho_id+" não encontrado ");
		return itensRepository.findByCarrinho(carrinho);
	}

}
