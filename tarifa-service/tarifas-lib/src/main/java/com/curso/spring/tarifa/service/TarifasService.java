package com.curso.spring.tarifa.service;

import java.util.List;

import com.curso.spring.tarifa.model.Tarifa;

public interface TarifasService {
	List<Tarifa> findAll();
	Tarifa findById(Long id);
	void delete(Long id);
	Tarifa save(Tarifa tarifa);
	Tarifa update(Tarifa tarifa);
}
