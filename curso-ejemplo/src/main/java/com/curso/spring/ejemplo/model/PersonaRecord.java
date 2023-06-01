package com.curso.spring.ejemplo.model;

import java.util.UUID;

public record PersonaRecord(UUID id, String nombre) {
	public String getUpNombre() {
		return nombre.toUpperCase();
	}
}
