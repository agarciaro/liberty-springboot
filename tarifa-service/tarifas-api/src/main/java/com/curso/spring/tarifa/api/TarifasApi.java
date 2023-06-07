package com.curso.spring.tarifa.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.curso.spring.tarifa.model.Tarifa;

public interface TarifasApi {

	@GetMapping()
	List<Tarifa> findAll();
	
	@GetMapping(path = "/{id}")
	Tarifa findById(Long id);
	
	@DeleteMapping(path = "/{id}")
	void delete(Long id);
	
	@PostMapping
	Tarifa save(Tarifa tarifa);
	
	@PutMapping
	Tarifa update(Tarifa tarifa);

}