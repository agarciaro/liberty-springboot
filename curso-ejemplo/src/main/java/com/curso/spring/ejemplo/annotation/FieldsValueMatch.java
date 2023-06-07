package com.curso.spring.ejemplo.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.curso.spring.ejemplo.validation.FieldsValueMatchValidator;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = FieldsValueMatchValidator.class)
public @interface FieldsValueMatch {
	String message() default "Los campos no coinciden";
	
	String field();
	String fieldMatch();
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
	
	@Target(TYPE)
	@Retention(RUNTIME)
	@interface List {
		FieldsValueMatch[] value();
	}
}
