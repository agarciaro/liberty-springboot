package com.curso.spring.tarifa.model;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Tarifa {
	Long id;
	String nombre;
	BigDecimal importe;
}
