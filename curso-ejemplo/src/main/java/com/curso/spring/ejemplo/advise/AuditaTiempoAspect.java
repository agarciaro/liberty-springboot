package com.curso.spring.ejemplo.advise;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.curso.spring.ejemplo.annotation.LogueaTiempo;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@ConditionalOnProperty(name = "loguea-tiempo.enabled", havingValue = "true")
public class AuditaTiempoAspect {
	
	@Around("@annotation(com.curso.spring.ejemplo.annotation.LogueaTiempo)")
	public Object logueaTiempoEjecucion(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("****** Antes de ejecutar el método");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String nombreMetodo = joinPoint.getTarget().getClass().getName() + "." + method.getName();
		
		LogueaTiempo anotacion = method.getAnnotation(LogueaTiempo.class);
		
		long tiempoInicio = System.currentTimeMillis();
		Object response = joinPoint.proceed();
		long tiempoEjecucion = System.currentTimeMillis() - tiempoInicio;
		
		if(tiempoEjecucion > anotacion.tiempoMaximo()) {
			log.warn("Tiempo ejecución excedido para {}:{}ms", nombreMetodo, tiempoEjecucion);
		} else {
			log.info("Tiempo ejecución para {}:{}ms", nombreMetodo, tiempoEjecucion);
		}
		
		log.info("****** Después de ejecutar el método");
		return response;
	}
	
}
