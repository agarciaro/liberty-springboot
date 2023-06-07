package com.curso.spring.producto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curso.spring.producto.entity.ProductoEntity;
import com.curso.spring.producto.model.Producto;

@Mapper
public interface ProductoMapper {
	
	ProductoMapper MAPPER = Mappers.getMapper(ProductoMapper.class);
	
	Producto toDto(ProductoEntity entity);
	ProductoEntity toEntity(Producto dto);
	
	List<Producto> toDto(List<ProductoEntity> entities);
	List<ProductoEntity> toEntity(List<Producto> dtos);
	
}
