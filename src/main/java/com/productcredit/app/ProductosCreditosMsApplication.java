package com.productcredit.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.productcredit.app.models.CreditProduct;
import com.productcredit.app.models.CreditProductType;
import com.productcredit.app.repository.ICreditProductRepository;
import com.productcredit.app.repository.ICreditProductTypeRepository;

import reactor.core.publisher.Flux;
@EnableEurekaClient
@SpringBootApplication
public class ProductosCreditosMsApplication implements CommandLineRunner{
	@Autowired
	private ReactiveMongoTemplate template;
	
	@Autowired
	private ICreditProductRepository productRepo;
	@Autowired
	private ICreditProductTypeRepository productTypeRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductosCreditosMsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(CreditProduct.class).subscribe();
		template.dropCollection(CreditProductType.class).subscribe();
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		
		CreditProductType tipP2 = new CreditProductType("Creditos");
		Flux.just(tipP2)
		.flatMap(tipP -> productTypeRepo.save(tipP))
		.thenMany(
				Flux.just(new CreditProduct("Personal", new Date(), 0.09, tipP2),
						new CreditProduct("Empresarial",  new Date(), 0.1, tipP2),
						new CreditProduct("Tarjeta de credito", new Date(),0.15, tipP2),
						new CreditProduct("Adelanto Efectivo", new Date(),0.15, tipP2)
						)
				).flatMap(pro -> productRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	}
}
