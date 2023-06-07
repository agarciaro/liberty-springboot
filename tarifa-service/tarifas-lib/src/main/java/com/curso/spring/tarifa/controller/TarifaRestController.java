package com.curso.spring.tarifa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.tarifa.api.TarifasApi;
import com.curso.spring.tarifa.model.Tarifa;
import com.curso.spring.tarifa.service.TarifasService;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaRestController implements TarifasApi {
	@Autowired
	private TarifasService tarifasService;

	@Override
	public List<Tarifa> findAll() {
		return tarifasService.findAll();
	}
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	public Tarifa findById(@PathVariable(name = "id", required = true) Long idTarifa) {
		return tarifasService.findById(idTarifa);
	}
	
	@Override
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tarifasService.delete(id);
	}
	
	@Override
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tarifa save(@RequestBody @Validated Tarifa tarifa) {
		return tarifasService.save(tarifa);
	}
	
	@Override
	public Tarifa update(@RequestBody Tarifa tarifa) {
		return tarifasService.update(tarifa);
	}
	
}
