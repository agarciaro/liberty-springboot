package com.curso.spring.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.producto.entity.ProductoEntity;
import com.curso.spring.producto.exception.MethodNotImplementedException;
import com.curso.spring.producto.exception.NotFoundException;
import com.curso.spring.producto.mapper.ProductoMapper;
import com.curso.spring.producto.model.Producto;
import com.curso.spring.producto.repository.ProductosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductosServiceImpl implements ProductosService {
	
	private final ProductosRepository productosRepository;
	private final ProductoMapper productoMapper = ProductoMapper.MAPPER;
	
	@Override
	public List<Producto> findAll() {
		List<ProductoEntity> productos = new ArrayList<>();
		productosRepository.findAll().forEach(productos::add);
		return productoMapper.toDto(productos);
	}

	@Override
	public Producto findById(Long id) {
		return productoMapper.toDto(productosRepository.findById(id).orElseThrow(() -> new NotFoundException()));
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void delete(Long id) {
		throw new MethodNotImplementedException();

	}

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NotFoundException.class)
	@Override
	public Producto save(Producto producto) {
		ProductoEntity entity = productoMapper.toEntity(producto);
		entity = productosRepository.save(entity);
		producto.setId(entity.getId());
		producto.setCodigo("NUEVO CODIGO");
		update(producto);
		return findById(entity.getId());
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Producto update(Producto producto) {
		ProductoEntity productoDB = productosRepository.findById(producto.getId()).get();
		productoDB.setCodigo(producto.getCodigo());
		
		return productoMapper.toDto(productosRepository.save(productoDB));
	}

}
