package com.curso.spring.inyeccion.dependencias.model;

public class Secretario implements Empleado{

	@Override
	public String getTarea() {
		return "Tarea de Secretario";
	}

}
