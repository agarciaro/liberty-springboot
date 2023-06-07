package com.curso.spring.producto.repository;

import java.util.List;

import com.curso.spring.producto.model.Producto;

public interface ProductosRepository {

	List<Producto> findAll();
	Producto findById(Long id);
	void delete(Long id);
	Producto save(Producto producto);
	Producto update(Producto producto);

}