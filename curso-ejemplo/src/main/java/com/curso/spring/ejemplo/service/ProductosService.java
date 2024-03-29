package com.curso.spring.ejemplo.service;

import java.util.List;
import java.util.UUID;

import com.curso.spring.ejemplo.model.Producto;

public interface ProductosService {
	List<Producto> findAll();
	Producto findById(UUID id);
	void delete(UUID id);
	Producto save(Producto producto);
	Producto update(Producto producto);
}
