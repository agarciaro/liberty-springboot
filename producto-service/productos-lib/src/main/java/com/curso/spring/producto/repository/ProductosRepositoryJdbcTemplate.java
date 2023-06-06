package com.curso.spring.producto.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.model.Producto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductosRepositoryJdbcTemplate implements ProductosRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Producto> findAll() {
		return null;
	}

	@Override
	public Producto findById(UUID id) throws NotFoundException {
		SqlParameterSource namedParameterSource = new MapSqlParameterSource().addValue("id", id);
//		return jdbcTemplate.queryForObject("SELECT * FROM producto WHERE id = ?", namedParameterSource, new BeanPropertyRowMapper<Producto>(Producto.class));
		return jdbcTemplate.queryForObject("SELECT * FROM producto WHERE id = ?", new Object[] {id}, Producto.class);
	}

	@Override
	public void delete(UUID id) {

	}

	@Override
	public Producto save(Producto producto) {
		jdbcTemplate.update("INSERT INTO producto VALUES (?, ?, ?)", producto.getId(), producto.getNombre(), producto.getCodigo());
		return findById(producto.getId());
	}

	@Override
	public Producto update(Producto producto) {
		return null;
	}
	
}
