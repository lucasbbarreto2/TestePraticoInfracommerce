package com.lucas.lojajogosapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Classe que representa um jogo no carrinho*/

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JOGO_ID")
	private Jogo produto;
	private Long quantidade;
	private Double subTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARRINHO_ID")
	@JsonIgnore
	private Carrinho carrinho;
			
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public Item(){}

	public Item(Jogo produto, Long quantidade, Carrinho carrinho) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.subTotal = produto.getPreco()*quantidade;
		this.carrinho = carrinho;
	}

	public Item(Jogo produto, Long quantidade, Double subTotal) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.subTotal = subTotal;
	}
	
	public Jogo getProduto() {
		return produto;
	}
	public void setProduto(Jogo produto) {
		this.produto = produto;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
		this.subTotal = this.quantidade * this.produto.getPreco();
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
}
