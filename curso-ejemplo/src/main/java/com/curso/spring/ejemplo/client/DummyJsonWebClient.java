package com.curso.spring.ejemplo.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DummyJsonWebClient {
	
	public Mono<String> getProducts(int id) {
		log.info("** Start DummyJsonWebClient");
		
		Mono<String> response = WebClient.create() //Mono<List<String>> no es lo mismo que Flux<String>
					.get()
					.uri("https://dummyjson.com/products/" + id)
					.retrieve()
					.bodyToMono(String.class);
		
		response.subscribe(p -> log.info("Response:{}",p));
		log.info("** End DummyJsonWebClient");
		
		return response;
	}
	
}
