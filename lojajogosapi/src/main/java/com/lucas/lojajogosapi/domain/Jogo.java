package com.lucas.lojajogosapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo Nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = "O campo Plataforma não pode ser vazio")
	private String pĺataforma;
	
	private String categoria;
	
	private String descricaoLonga;
	
	@NotNull(message = "O campo Preço não pode ser vazio")
	private Double preco;
	
	@OneToMany(mappedBy = "jogo")
	private List<Comentarios> comentarios;
	
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

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentarios comentario) {
		this.comentarios.add(comentario);
	}
	
}
