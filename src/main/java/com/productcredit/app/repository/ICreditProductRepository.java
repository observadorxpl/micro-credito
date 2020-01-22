package com.productcredit.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productcredit.app.models.CreditProduct;
@Repository
public interface ICreditProductRepository extends ReactiveMongoRepository<CreditProduct, String>{

}
