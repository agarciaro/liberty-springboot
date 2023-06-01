package com.curso.spring.producto.model;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Producto {
	UUID id;
	String nombre;
	String codigo;
}
