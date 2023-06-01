package com.curso.spring.inyeccion.dependencias.service;

import java.util.HashMap;
import java.util.Map;

import com.curso.spring.inyeccion.dependencias.model.Empleado;
import com.curso.spring.inyeccion.dependencias.model.Jefe;
import com.curso.spring.inyeccion.dependencias.model.Secretario;

public class Contenedor implements IContenedor {
	
	private static Contenedor contenedor;
	
	private static Map<String, Empleado> beans = new HashMap<>();
	
	private Contenedor() {
		beans.put("jefe", new Jefe());
		beans.put("secretario", new Secretario());
	}
	
	public static Contenedor getInstance() {
		if(contenedor == null) {
			contenedor = new Contenedor();
		}
		return contenedor;
	}
	
	@Override
	public Empleado getBean(String tipoEmpleado) {
		return beans.get(tipoEmpleado);
	}
}
