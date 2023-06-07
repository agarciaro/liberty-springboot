package com.curso.spring.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.curso.spring.producto.repository.ProductosRepository;

@SpringBootApplication
@EnableCaching
public class ProductoApplication {
	
	@Autowired
	ProductosRepository productosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
	}
	
}
