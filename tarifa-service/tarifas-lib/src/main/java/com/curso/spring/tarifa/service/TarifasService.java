package com.curso.spring.tarifa.service;

import com.curso.spring.tarifa.model.Tarifa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TarifasService {
	Flux<Tarifa> findAll();
	Mono<Tarifa> findById(Long id);
	void delete(Long id);
	Mono<Tarifa> save(Tarifa tarifa);
	Mono<Tarifa> update(Tarifa tarifa);
}
