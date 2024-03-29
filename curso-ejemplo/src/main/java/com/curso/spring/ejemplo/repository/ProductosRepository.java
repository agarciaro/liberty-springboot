package com.curso.spring.ejemplo.repository;

import java.util.List;
import java.util.UUID;

import com.curso.spring.ejemplo.model.Producto;

public interface ProductosRepository {

	List<Producto> findAll();
	Producto findById(UUID id);
	void delete(UUID id);
	Producto save(Producto producto);
	Producto update(Producto producto);

}