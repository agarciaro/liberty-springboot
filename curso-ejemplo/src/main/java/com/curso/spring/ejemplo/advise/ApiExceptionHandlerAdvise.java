package com.curso.spring.ejemplo.advise;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.curso.spring.ejemplo.exception.NotFoundException;
import com.curso.spring.ejemplo.model.ApiError;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Component
@Slf4j
public class ApiExceptionHandlerAdvise {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiError handleNotFoundException(NotFoundException ex) {
		ApiError apiError = new ApiError(1, "Elemento no encontrado");
		return apiError;
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiError handleRequestNotValidException(MethodArgumentNotValidException ex) {
		log.error("Error validation request:", ex);
		ApiError apiError = new ApiError(3, ex.getMessage());
		return apiError;
	}
	
//	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handleNullPointerException(NullPointerException ex) {
		ApiError apiError = new ApiError(-1, null);
//		log.error("NULL POINTER {}", apiError.getDescription().toLowerCase());
		return apiError;
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handleGenericException(Throwable ex) {
		log.error("Atrapada exception: {}", ex.getClass().getCanonicalName());
		ApiError apiError = new ApiError(2, ex.getMessage());
		return apiError;
	}
	
}
