package com.curso.spring.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.producto.entity.ProductoEntity;
import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.mapper.ProductoMapper;
import com.curso.spring.producto.model.Producto;
import com.curso.spring.producto.repository.ProductosRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"productos"})
@Slf4j
public class ProductosServiceImpl implements ProductosService {
	
	private final ProductosRepository productosRepository;
	private final ProductoMapper productoMapper = ProductoMapper.MAPPER;
	
	@Override
	public List<Producto> findAll() {
		List<ProductoEntity> productos = new ArrayList<>();
		productosRepository.findAll().forEach(productos::add);
		return productoMapper.toDto(productos);
	}

	@Cacheable(key ="#id")
	@Override
	public Producto findById(Long id) {
		log.info("En findById:{}", id);
		return productoMapper.toDto(productosRepository.findById(id).orElseThrow(() -> new NotFoundException()));
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@CacheEvict(key ="#id")
	@Override
	public void delete(Long id) {
		productosRepository.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NotFoundException.class)
	@CachePut(key = "#producto.id")
	@Override
	public Producto save(Producto producto) {
		ProductoEntity entity = productoMapper.toEntity(producto);
		entity = productosRepository.save(entity);
		return productoMapper.toDto(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@CachePut(key = "#producto.id")
	@Override
	public Producto update(Producto producto) {
		ProductoEntity entity = productoMapper.toEntity(producto);
		
		return productoMapper.toDto(productosRepository.save(entity));
	}

}
