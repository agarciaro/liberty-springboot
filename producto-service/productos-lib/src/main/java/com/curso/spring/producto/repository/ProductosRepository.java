package com.curso.spring.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.producto.entity.ProductoEntity;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Long> {

}