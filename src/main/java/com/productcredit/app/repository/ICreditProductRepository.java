package com.productcredit.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productcredit.app.models.Bank;
import com.productcredit.app.models.CreditProduct;

import reactor.core.publisher.Flux;
@Repository
public interface ICreditProductRepository extends ReactiveMongoRepository<CreditProduct, String>{
	Flux<CreditProduct> findByBank(Bank bank);
}
