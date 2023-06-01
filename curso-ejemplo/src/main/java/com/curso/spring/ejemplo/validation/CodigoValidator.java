package com.curso.spring.ejemplo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.curso.spring.ejemplo.annotation.CodigoConstraint;

public class CodigoValidator implements ConstraintValidator<CodigoConstraint, String> {
	
	@Override
	public void initialize(CodigoConstraint constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String codigo, ConstraintValidatorContext context) {
		return codigo != null && codigo.matches("[0-9]+");// && codigo.length() >= 6 && codigo.length() <= 10;
	}

}
