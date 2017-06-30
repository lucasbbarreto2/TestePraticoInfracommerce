package com.lucas.lojajogosapi.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CARRINHO_ID")
	Carrinho carrinho;
	
	public Usuario(){
		this.carrinho = new Carrinho();
	}
	
	public Usuario(Long id, String nome, Carrinho carrinho) {
		this.id = id;
		this.nome = nome;
		this.carrinho = carrinho;
	}
	
	public Usuario(String nome) {
		this.nome = nome;
		this.carrinho = new Carrinho();
	}
	
	public Carrinho getCarrinho() {
		return this.carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
