package com.productocredito.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productocredito.app.models.TipoProducto;
@Repository
public interface ITipoProductoRepository extends ReactiveMongoRepository<TipoProducto, String>{

}
