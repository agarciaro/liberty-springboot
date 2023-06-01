package com.curso.spring.ejemplo.model;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.curso.spring.ejemplo.annotation.CodigoConstraint;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@JacksonXmlRootElement
public class Producto {
	UUID id;
	
	@NotEmpty
	String nombre;
	
	@Min(6)
	@Max(10)
	@CodigoConstraint(message = "El código del Producto no es válido")
	String codigo;
}
