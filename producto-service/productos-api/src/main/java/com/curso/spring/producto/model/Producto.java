package com.curso.spring.producto.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Producto {
	Long id;
	String nombre;
	String codigo;
}
