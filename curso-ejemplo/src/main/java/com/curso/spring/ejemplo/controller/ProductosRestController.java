package com.curso.spring.ejemplo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.ejemplo.annotation.LogueaTiempo;
import com.curso.spring.ejemplo.exception.NotFoundException;
import com.curso.spring.ejemplo.model.Producto;
import com.curso.spring.ejemplo.service.ProductosService;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductosRestController {
	@Autowired
//	@Qualifier("impl2")
	private ProductosService productosService;
//	@Autowired
//	private GarantiasService garantiasService;
	
	@LogueaTiempo(tiempoMaximo = 1000)
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Producto> findAll() {
		return productosService.findAll();
	}
	
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
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
	public Producto save(@RequestBody Producto producto) {
		return productosService.save(producto);
	}
	
	@PutMapping
	public Producto update(@RequestBody Producto producto) {
		return productosService.update(producto);
	}
	
}
