package com.curso.spring.tarifa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.spring.tarifa.model.Tarifa;
import com.curso.spring.tarifa.repository.TarifasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarifasServiceImpl implements TarifasService {
	
	private final TarifasRepository tarifasRepository;
	
	@Override
	public List<Tarifa> findAll() {
//		return tarifasRepository.findAll();
		return new ArrayList<>();
	}

	@Override
	public Tarifa findById(Long id) {
		return null;
//		return tarifasRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		

	}

	@Override
	public Tarifa save(Tarifa tarifa) {
		return null;
//		return tarifasRepository.save(tarifa);
	}

	@Override
	public Tarifa update(Tarifa producto) {
		return null;
	}


}
