package com.curso.spring.tarifa.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("tarifas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifaEntity {
	
	@Id
	private Long id;
	
	private String nombre;
	private BigDecimal importe;
	
}
