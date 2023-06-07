package com.curso.spring.producto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.producto.entity.ProductoEntity;

@Repository
public interface ProductosRepository extends CrudRepository<ProductoEntity, Long> {

}