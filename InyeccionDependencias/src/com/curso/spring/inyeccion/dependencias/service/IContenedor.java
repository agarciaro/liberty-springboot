package com.curso.spring.inyeccion.dependencias.service;

import com.curso.spring.inyeccion.dependencias.model.Empleado;

public interface IContenedor {
	Empleado getBean(String tipoEmpleado);
}