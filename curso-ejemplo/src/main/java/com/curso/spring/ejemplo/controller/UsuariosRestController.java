package com.curso.spring.ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.ejemplo.model.Usuario;
import com.curso.spring.ejemplo.repository.UsuariosReactiveRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {
	
	@Autowired
	UsuariosReactiveRepository usuariosReactiveRepository;
	
	@PutMapping
	public Usuario update(@RequestBody @Validated Usuario usuario) {
		return usuario;
	}
	
	@GetMapping
	public Flux<Usuario> findAll() {
		return usuariosReactiveRepository.findAll();
	}
}
