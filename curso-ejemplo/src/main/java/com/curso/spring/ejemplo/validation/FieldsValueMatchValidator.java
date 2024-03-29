package com.curso.spring.ejemplo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.curso.spring.ejemplo.annotation.FieldsValueMatch;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

	private String field;
	private String fieldMatch;
	
	@Override
	public void initialize(FieldsValueMatch constraintAnnotation) {
		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object fieldValueMatch = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
		
		if(fieldValue != null) {
			return fieldValue.equals(fieldValueMatch);
		}
		
		return fieldValueMatch == null;
	}
	
	
}
