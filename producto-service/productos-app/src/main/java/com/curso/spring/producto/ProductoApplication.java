package com.curso.spring.producto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.spring.producto.model.Producto;
import com.curso.spring.producto.repository.ProductosRepository;

@SpringBootApplication
public class ProductoApplication {
	
	@Autowired
	ProductosRepository productosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		productosRepository.save(new Producto(null, "Producto1", "Codigo1"));
	}

}
