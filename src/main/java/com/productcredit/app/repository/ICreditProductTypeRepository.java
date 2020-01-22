package com.productcredit.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productcredit.app.models.CreditProductType;
@Repository
public interface ICreditProductTypeRepository extends ReactiveMongoRepository<CreditProductType, String>{

}
