package com.curso.spring.tarifa.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Value
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {
	private Long id;
	private String nombre;
	private BigDecimal importe;
}
