package com.curso.spring.ejemplo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.ejemplo.service.ProductosService;
import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.model.Producto;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {
	@Autowired
	private ProductosService productosService;

	@GetMapping()
	public List<Producto> findAll() {
		return productosService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto findById(@PathVariable(name = "id", required = true) UUID idProducto) throws NotFoundException {
		return productosService.findById(idProducto);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		productosService.delete(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto save(@RequestBody @Validated Producto producto) {
		return productosService.save(producto);
	}
	
	@PutMapping
	public Producto update(@RequestBody Producto producto) {
		return productosService.update(producto);
	}
	
}
