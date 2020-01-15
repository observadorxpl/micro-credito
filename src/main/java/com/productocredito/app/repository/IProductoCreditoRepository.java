package com.productocredito.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productocredito.app.models.ProductoCredito;
@Repository
public interface IProductoCreditoRepository extends ReactiveMongoRepository<ProductoCredito, String>{

}
