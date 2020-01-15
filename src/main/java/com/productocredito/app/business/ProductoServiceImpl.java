package com.productocredito.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productocredito.app.models.ProductoCredito;
import com.productocredito.app.repository.IProductoCreditoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoCreditoRepository productoRepo;
	
	@Override
	public Flux<ProductoCredito> findAll() {
		return productoRepo.findAll();
	}

	@Override
	public Mono<ProductoCredito> finById(String id) {
		return productoRepo.findById(id);
	}

	@Override
	public Mono<ProductoCredito> save(ProductoCredito t) {
		return productoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(ProductoCredito t) {
		return productoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return productoRepo.deleteById(id);
	}
	
	
}