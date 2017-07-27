package com.lucas.lojajogosapi.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.FetchType;


@Entity
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotEmpty(message = "Necessário insirir comentário")
	@JsonProperty("comentario")
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOGO_ID")
	@JsonIgnore
	private Jogo jogo;
	
	private String data;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="USUARIO_ID")
	@NotEmpty(message = "Necessário usuário logado para inserir um comentário")
	private String usuario;
	
	public Comentarios(){}
	
	public Comentarios(String texto){
		this.texto = texto;
	}

	public Comentarios(String texto, Jogo jogo) {
		super();
		this.texto = texto;
		this.jogo = jogo;
		this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("'Comentário inserido em' EEEE, dd 'de' MMMM 'de' yyyy, 'às' HH:mm"));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public String getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data.format(DateTimeFormatter.ofPattern("'Comentário inserido em' EEEE, dd 'de' MMMM 'de' yyyy, 'às' HH:mm"));
		//
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
	
}
