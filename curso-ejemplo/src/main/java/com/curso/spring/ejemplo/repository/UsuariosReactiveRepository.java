package com.curso.spring.ejemplo.repository;

import java.time.Duration;

import org.springframework.stereotype.Component;

import com.curso.spring.ejemplo.model.Usuario;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class UsuariosReactiveRepository {
	public Flux<Usuario> findAll() {
		Flux<Usuario> usuariosFlux = Flux.just(
				new Usuario("user1", null, null, null, null),
				new Usuario("user2", null, null, null, null),
				new Usuario("user3", null, null, null, null))
				.delayElements(Duration.ofSeconds(1));
		usuariosFlux.subscribe(u -> log.info("Usuario:{}", u));
		return usuariosFlux;
	}
}
