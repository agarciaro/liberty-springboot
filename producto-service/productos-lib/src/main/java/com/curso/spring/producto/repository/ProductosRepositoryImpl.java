package com.curso.spring.producto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.model.Producto;

import lombok.extern.slf4j.Slf4j;

//@Repository
@Slf4j
public class ProductosRepositoryImpl implements ProductosRepository {
	
	private final Map<Long, Producto> productos = new HashMap<>();
	
	{

		productos.put(1L, new Producto(1L, "Nombre1", "0123456"));

		productos.put(2L, new Producto(2L, "Nombre2", "9876543210"));

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
	public Producto findById(Long id) throws NotFoundException {
		Producto producto = productos.get(id);
//		log.info("Producto findById:{}", producto.getNombre());
		if(producto == null) {
			throw new NotFoundException();
		}
		return producto;
	}

	@Override
	public void delete(Long id) {
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
