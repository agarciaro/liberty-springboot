package com.curso.spring.ejemplo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "dummy-producto", url = "${dummy-productos.url}")
public interface DummyJsonFeignClient {
	
	@GetMapping("/products/{id}")
	String getProducts(@PathVariable int id);
	
}
