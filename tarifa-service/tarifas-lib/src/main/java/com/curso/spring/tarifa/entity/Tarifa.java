package com.curso.spring.tarifa.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Tarifa {
	
	@Id
	private Long id;
	
	private String nombre;
	private BigDecimal importe;
	
}
