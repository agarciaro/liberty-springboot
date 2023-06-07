package com.curso.spring.producto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Value
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	private Long id;
	private String nombre;
	private String codigo;
}
