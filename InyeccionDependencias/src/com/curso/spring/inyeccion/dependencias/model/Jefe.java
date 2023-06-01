package com.curso.spring.inyeccion.dependencias.model;

public class Jefe implements Empleado{

	@Override
	public String getTarea() {
		return "Tarea de Jefe";
	}

}
