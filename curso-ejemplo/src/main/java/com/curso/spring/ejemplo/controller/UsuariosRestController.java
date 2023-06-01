package com.curso.spring.ejemplo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.ejemplo.model.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {
	@PutMapping
	public Usuario update(@RequestBody @Validated Usuario usuario) {
		return usuario;
	}
}
