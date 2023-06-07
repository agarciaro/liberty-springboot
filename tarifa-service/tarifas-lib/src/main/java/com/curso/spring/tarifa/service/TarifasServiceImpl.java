package com.curso.spring.tarifa.service;

import org.springframework.stereotype.Service;

import com.curso.spring.tarifa.entity.TarifaEntity;
import com.curso.spring.tarifa.mapper.TarifaMapper;
import com.curso.spring.tarifa.model.Tarifa;
import com.curso.spring.tarifa.repository.TarifasRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TarifasServiceImpl implements TarifasService {
	
	private final TarifasRepository tarifasRepository;
	private final TarifaMapper tarifaMapper = TarifaMapper.MAPPER;

	@Override
	public Flux<Tarifa> findAll() {
		Flux<TarifaEntity> entities = tarifasRepository.findAll();
		return entities.map(t -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
			return tarifaMapper.toDto(t);
		});
	}

	@Override
	public Mono<Tarifa> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mono<Tarifa> save(Tarifa tarifa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Tarifa> update(Tarifa tarifa) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
