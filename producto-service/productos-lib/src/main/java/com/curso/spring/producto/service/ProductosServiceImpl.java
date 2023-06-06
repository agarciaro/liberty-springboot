package com.curso.spring.producto.service;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.curso.spring.producto.exception.MethodNotImplementedException;
import com.curso.spring.producto.model.Producto;
import com.curso.spring.producto.repository.ProductosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosServiceImpl implements ProductosService {
	
	private final ProductosRepository productosRepository;
	
//	@Autowired
//	public ProductosServiceImpl(ProductosRepository productosRepository) {
//		super();
//		this.productosRepository = productosRepository;
//	}
	
	@Override
	public List<Producto> findAll() {
		return productosRepository.findAll();
	}

	@Override
	public Producto findById(UUID id) {
		return productosRepository.findById(id);
	}

	@Override
	public void delete(UUID id) {
		throw new MethodNotImplementedException();

	}

	@Override
	public Producto save(Producto producto) {
		return productosRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		throw new MethodNotImplementedException();
	}


}
