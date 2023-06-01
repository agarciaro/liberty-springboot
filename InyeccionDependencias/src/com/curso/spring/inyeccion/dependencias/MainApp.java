package com.curso.spring.inyeccion.dependencias;

import com.curso.spring.inyeccion.dependencias.model.Empleado;
import com.curso.spring.inyeccion.dependencias.service.Contenedor;
import com.curso.spring.inyeccion.dependencias.service.IContenedor;

public class MainApp {

	public static void main(String[] args) {
		
		IContenedor contenedor = Contenedor.getInstance();
				
		Empleado empleado = contenedor.getBean(args[0]);
		
		System.out.println("Tarea empleado:" + empleado.getTarea());

	}

}
