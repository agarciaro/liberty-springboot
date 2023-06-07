package com.curso.spring.tarifa.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.tarifa.entity.TarifaEntity;

@Repository
public interface TarifasRepository extends R2dbcRepository<TarifaEntity, Long> {
	

}