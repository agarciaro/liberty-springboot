package com.curso.spring.tarifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableCaching
public class TarifaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TarifaApplication.class, args);
	}

}
