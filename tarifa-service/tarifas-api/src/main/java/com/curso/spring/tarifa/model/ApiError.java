package com.curso.spring.tarifa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	private int errorCode = 0;
	private String description = "Uknown Error";
}
