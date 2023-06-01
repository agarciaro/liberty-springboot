package com.curso.spring.ejemplo.model;

import java.util.UUID;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@JacksonXmlRootElement
public class Producto {
	UUID id;
	String nombre;
}
