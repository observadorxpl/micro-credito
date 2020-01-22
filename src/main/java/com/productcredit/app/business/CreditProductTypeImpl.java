package com.productcredit.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcredit.app.models.CreditProductType;
import com.productcredit.app.repository.ICreditProductTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditProductTypeImpl implements ICreditProductTypeService {

	@Autowired
	private ICreditProductTypeRepository tipoProductoRepo;

	@Override
	public Flux<CreditProductType> findAll() {
		return tipoProductoRepo.findAll();
	}

	@Override
	public Mono<CreditProductType> finById(String id) {
		return tipoProductoRepo.findById(id);
	}

	@Override
	public Mono<CreditProductType> save(CreditProductType t) {
		return tipoProductoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(CreditProductType t) {
		return tipoProductoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return tipoProductoRepo.deleteById(id);
	}

}