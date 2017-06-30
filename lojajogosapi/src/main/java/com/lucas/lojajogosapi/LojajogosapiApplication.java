package com.lucas.lojajogosapi;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.lojajogosapi.domain.Jogo;
import com.lucas.lojajogosapi.domain.Usuario;
import com.lucas.lojajogosapi.service.JogosServiceInterface;
import com.lucas.lojajogosapi.service.UsuariosServiceInterface;

@SpringBootApplication
public class LojajogosapiApplication {
	
	@Autowired
	private JogosServiceInterface jogosService;
	
	@Autowired
	private UsuariosServiceInterface usuariosService;
	
	@PostConstruct
	 public void init() {
		/*Cadastrando Jogos*/
		jogosService.salvar(new Jogo(1L, "Deamon Souls", "PC", "RPG", "Jogo bom de RPG", 100.0));
		jogosService.salvar(new Jogo(2L, "Dark Souls", "PC", "RPG", "Jogo muuuito bom de RPG", 200.0));
		jogosService.salvar(new Jogo(3L, "Halo", "X-Box One", "Ação", "Jogo de ação da MS", 300.0));
		jogosService.salvar(new Jogo(4L, "Fifa 2018", "Playstation 4", "Esporte", "Jogo de futebol", 90.0));
		
		/*Cadastrando Usuario*/
		usuariosService.criar(new Usuario("Lucas"));
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LojajogosapiApplication.class, args);
	}
}
