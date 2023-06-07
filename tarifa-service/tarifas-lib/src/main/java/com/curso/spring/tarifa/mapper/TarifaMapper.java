package com.curso.spring.tarifa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curso.spring.tarifa.entity.TarifaEntity;
import com.curso.spring.tarifa.model.Tarifa;

@Mapper
public interface TarifaMapper {
	
	TarifaMapper MAPPER = Mappers.getMapper(TarifaMapper.class);
	
	Tarifa toDto(TarifaEntity entity);
	TarifaEntity toEntity(Tarifa dto);
	
	List<Tarifa> toDto(List<TarifaEntity> entities);
	List<TarifaEntity> toEntity(List<Tarifa> dtos);
	
}
