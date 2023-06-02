package com.curso.spring.producto.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.model.Producto;

public interface ProductosApi {

	@GetMapping()
	List<Producto> findAll();
	
	@GetMapping(path = "/{id}")
	Producto findById(UUID idProducto) throws NotFoundException;
	
	@DeleteMapping(path = "/{id}")
	void delete(UUID id);
	
	@PostMapping
	Producto save(Producto producto);
	
	@PutMapping
	Producto update(Producto producto);

}