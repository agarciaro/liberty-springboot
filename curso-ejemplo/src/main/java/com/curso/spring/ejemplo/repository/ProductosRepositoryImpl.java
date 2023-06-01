package com.curso.spring.ejemplo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.curso.spring.ejemplo.exception.NotFoundException;
import com.curso.spring.ejemplo.model.Producto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductosRepositoryImpl implements ProductosRepository {
	
	private final Map<UUID, Producto> productos = new HashMap<>();
	
	{

		productos.put(UUID.fromString("8bcc5537-d3c2-4e80-9d3f-3fdb41fc293b"), new Producto(UUID.fromString("8bcc5537-d3c2-4e80-9d3f-3fdb41fc293b"), "Nombre1"));

		productos.put(UUID.fromString("de87ae95-aa9b-4723-acf4-f7b1618465b6"), new Producto(UUID.fromString("de87ae95-aa9b-4723-acf4-f7b1618465b6"), "Nombre2"));

	}
	
	@Override
	public List<Producto> findAll() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			log.error("Error al dormir", e);
		}
		return new ArrayList<>(productos.values());
	}

	@Override
	public Producto findById(UUID id) throws NotFoundException {
		Producto producto = productos.get(id);
		log.info("Producto findById:{}", producto.getNombre());
		if(producto == null) {
			throw new NotFoundException();
		}
		return producto;
	}

	@Override
	public void delete(UUID id) {
		productos.remove(id);
	}

	@Override
	public Producto save(Producto producto) {
		return productos.put(producto.getId(), producto);
	}

	@Override
	public Producto update(Producto producto) {
		Producto productoOld = productos.get(producto.getId());
		if(productoOld == null) {
			throw new NotFoundException();
		}
		return save(producto);
	}
	
}
