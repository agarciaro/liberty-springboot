package com.curso.spring.producto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("productos")
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
	@Id
	private Long id;
	private String nombre;
	private String codigo;
}
