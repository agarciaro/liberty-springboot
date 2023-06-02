package com.curso.spring.ejemplo.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.curso.spring.ejemplo")
public class FeignClientsConfiguration {

}
