package com.lucas.lojajogosapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String pĺataforma;
	
	private String categoria;
	
	private String descricaoLonga;
	
	private Double preco;

	public Jogo(){}
	
	public Jogo(Long id){
		this.id = id;
	}

	public Jogo(Long id, String nome, String pĺataforma, String categoria, String descricaoLonga, Double preco) {

		this.id = id;
		this.nome = nome;
		this.pĺataforma = pĺataforma;
		this.categoria = categoria;
		this.descricaoLonga = descricaoLonga;
		this.setPreco(preco);
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
	public String getPĺataforma() {
		return pĺataforma;
	}
	public void setPĺataforma(String pĺataforma) {
		this.pĺataforma = pĺataforma;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricaoLonga() {
		return descricaoLonga;
	}
	public void setDescricaoLonga(String descricaoLonga) {
		this.descricaoLonga = descricaoLonga;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
