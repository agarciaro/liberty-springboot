package com.curso.spring.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.producto.api.ProductosApi;
import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.model.Producto;
import com.curso.spring.producto.service.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController implements ProductosApi {
	@Autowired
	private ProductosService productosService;

	@Override
	public List<Producto> findAll() {
		return productosService.findAll();
	}
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	public Producto findById(@PathVariable(name = "id", required = true) Long idProducto) throws NotFoundException {
		return productosService.findById(idProducto);
	}
	
	@Override
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productosService.delete(id);
	}
	
	@Override
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto save(@RequestBody @Validated Producto producto) {
		return productosService.save(producto);
	}
	
	@Override
	public Producto update(@RequestBody Producto producto) {
		return productosService.update(producto);
	}
	
}
