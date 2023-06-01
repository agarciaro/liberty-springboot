package com.curso.spring.ejemplo.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.curso.spring.ejemplo.validation.CodigoValidator;

@Documented
@Retention(RUNTIME)
@Target({ FIELD })
@Constraint(validatedBy = CodigoValidator.class)
public @interface CodigoConstraint {
	String message() default "Código no válido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
