package com.curso.spring.ejemplo.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GarantiasService {
	public void status() {
		log.info("OK");
	}
}
