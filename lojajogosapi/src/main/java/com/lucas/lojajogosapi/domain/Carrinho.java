package com.lucas.lojajogosapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "carrinho")
	private List<Item> itens;
	private Double total;
	
	@OneToOne(mappedBy="carrinho")
	Usuario usuario;
	
	public Carrinho() {}
	
	public Carrinho(Usuario user) {
		this.usuario = user;
	}

	public Carrinho(Long id, List<Item> itens, Double total) {
		this.id = id;
		this.itens = itens;
		this.total = total;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
