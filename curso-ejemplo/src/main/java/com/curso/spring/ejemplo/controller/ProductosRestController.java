package com.curso.spring.ejemplo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.curso.spring.ejemplo.annotation.LogueaTiempo;
import com.curso.spring.ejemplo.client.DummyJsonFeignClient;
import com.curso.spring.ejemplo.client.DummyJsonRestTemplateClient;
import com.curso.spring.ejemplo.client.DummyJsonWebClient;
import com.curso.spring.ejemplo.exception.NotFoundException;
import com.curso.spring.ejemplo.model.Producto;
import com.curso.spring.ejemplo.service.ProductosService;

import lombok.extern.slf4j.Slf4j;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/productos")
@Slf4j
public class ProductosRestController {
	@Autowired
//	@Qualifier("impl2")
	private ProductosService productosService;
//	@Autowired
//	private GarantiasService garantiasService;
	
	@Autowired
	DummyJsonRestTemplateClient dummyJsonRestTemplateClient;
	
	@Autowired
	DummyJsonWebClient dummyJsonWebClient;
	
	@Autowired
	DummyJsonFeignClient dummyJsonFeignClient;
	
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
	
	@GetMapping(path = "/{id}/sync/mock")
	@ResponseStatus(HttpStatus.OK)
	public String findSyncMockById(@PathVariable(name = "id", required = true) int idProducto) {
		String productosStr = dummyJsonRestTemplateClient.getProducts(idProducto);
//		log.info("RESPUESTA PRODUCTOS DUMMY:{}", productosStr);
		return productosStr;
	}
	
	@GetMapping(path = "/{id}/sync/feign/mock")
	@ResponseStatus(HttpStatus.OK)
	public String findSyncFeignMockById(@PathVariable(name = "id", required = true) int idProducto) {
		log.info("** Start DummyJsonFeignClient");
		String productosStr = dummyJsonFeignClient.getProducts(idProducto);
		log.info("RESPUESTA PRODUCTOS DUMMY:{}", productosStr);
		log.info("** End DummyJsonFeignClient");
		return productosStr;
	}
	
	@GetMapping(path = "/{id}/async/mock")
	@ResponseStatus(HttpStatus.OK)
	public String findAsyncMockById(@PathVariable(name = "id", required = true) int idProducto) {
		String productosStr = dummyJsonWebClient.getProducts(idProducto).block();
//		log.info("RESPUESTA PRODUCTOS DUMMY:{}", productosStr);
		return productosStr;
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
