package com.curso.spring.tarifa.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.curso.spring.tarifa.model.Tarifa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TarifasApi {

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Tarifa> findAll();
	
	@GetMapping(path = "/{id}")
	Mono<Tarifa> findById(Long id);
	
	@DeleteMapping(path = "/{id}")
	void delete(Long id);
	
	@PostMapping
	Mono<Tarifa> save(Tarifa tarifa);
	
	@PutMapping
	Mono<Tarifa> update(Tarifa tarifa);

}