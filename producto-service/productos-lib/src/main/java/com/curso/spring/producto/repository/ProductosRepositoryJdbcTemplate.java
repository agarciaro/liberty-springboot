package com.curso.spring.producto.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
	public Producto findById(Long id) throws NotFoundException {
		return jdbcTemplate.queryForObject("SELECT * FROM productos WHERE id = ?", new BeanPropertyRowMapper<>(Producto.class), id);
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Producto save(Producto producto) {
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		var sql = """
				INSERT INTO productos (nombre, codigo) 
				VALUES (?, ?);
				""";
		
		jdbcTemplate.update(conn -> {
			//Compilar la SQL
			PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getCodigo());
			
			return preparedStatement;
		}, generatedKeyHolder);
		
		Long id = (Long) generatedKeyHolder.getKeys().get("id");
		
		return findById(id);
	}

	@Override
	public Producto update(Producto producto) {
		return null;
	}
	
}
