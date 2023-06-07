package com.curso.spring.tarifa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.curso.spring.tarifa.entity.TarifaEntity;
import com.curso.spring.tarifa.mapper.TarifaMapper;
import com.curso.spring.tarifa.model.Tarifa;
import com.curso.spring.tarifa.repository.TarifasRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
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

	@Cacheable("tarifasCache")
	@Override
	public Mono<Tarifa> findById(Long id) {
		log.info("Dentro de findById:{}", id);
		return tarifasRepository.findById(id).map(t -> tarifaMapper.toDto(t));
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
