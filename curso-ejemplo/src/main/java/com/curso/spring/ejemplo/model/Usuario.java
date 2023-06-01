package com.curso.spring.ejemplo.model;

import com.curso.spring.ejemplo.annotation.FieldsValueMatch;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@JacksonXmlRootElement
@FieldsValueMatch.List({
	@FieldsValueMatch(
		field = "password",
		fieldMatch = "password2",
		message = "Las contraseñas no coinciden"
	),
	@FieldsValueMatch(
		field = "numTarjeta",
		fieldMatch = "numTarjeta2",
		message = "Los números de tarjeta no coinciden"
	)
})
//@FieldsValueMatch(
//	field = "password",
//	fieldMatch = "password2",
//	message = "Las contraseñas no coinciden"
//)
public class Usuario {
	String nombre;
	
//	@NotNull
	String password;
//	@NotNull
	String password2;
	
	Long numTarjeta;
	Long numTarjeta2;
}
