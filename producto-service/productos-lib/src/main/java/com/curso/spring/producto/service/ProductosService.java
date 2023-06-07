package com.curso.spring.producto.service;

import java.util.List;

import com.curso.spring.producto.model.Producto;

public interface ProductosService {
	List<Producto> findAll();
	Producto findById(Long id);
	void delete(Long id);
	Producto save(Producto producto);
	Producto update(Producto producto);
}
