package com.curso.spring.ejemplo.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DummyJsonRestTemplateClient {
	
	public String getProducts(int id) {
		log.info("** Start DummyJsonRestTemplateClient");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate
					.exchange("https://dummyjson.com/products/" + id, HttpMethod.GET, null, 
							new ParameterizedTypeReference<String>() {
					});
		
		log.info("Response:{} - {}", response.getStatusCode(), response.getBody());
		log.info("** End DummyJsonRestTemplateClient");
		
		return response.getBody();
	}
	
}
