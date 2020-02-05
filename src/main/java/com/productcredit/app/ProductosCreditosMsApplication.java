package com.productcredit.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.productcredit.app.models.Bank;
import com.productcredit.app.models.CreditProduct;
import com.productcredit.app.models.CreditProductType;
import com.productcredit.app.repository.ICreditProductRepository;
import com.productcredit.app.repository.ICreditProductTypeRepository;

import reactor.core.publisher.Flux;
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class ProductosCreditosMsApplication implements CommandLineRunner{
	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;
	
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
		/*
		template.dropCollection(CreditProduct.class).subscribe();
		template.dropCollection(CreditProductType.class).subscribe();
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		
		CreditProductType tipP2 = new CreditProductType("Creditos");
		Flux.just(tipP2)
		.flatMap(tipP -> productTypeRepo.save(tipP)).subscribe();
		
		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/100").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new CreditProduct("Personal", new Date(), 0.09, 9, tipP2, bank));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Personal", new Date(), 0.09, 9, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Empresarial", new Date(), 0.01, 10, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Tarjeta de credito", new Date(), 0.15, 11, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Adelanto Efectivo", new Date(), 0.15, 12, tipP2, pro.getBank()));
		}).subscribe();
		
		
		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/101").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new CreditProduct("Personal", new Date(), 0.09, 9,  tipP2, bank));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Personal", new Date(), 0.09, 9,  tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Empresarial", new Date(), 0.01, 10, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Tarjeta de credito", new Date(), 0.15,  11, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Adelanto Efectivo", new Date(), 0.15, 12, tipP2, pro.getBank()));
		}).subscribe();
		
		
		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/102").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new CreditProduct("Personal", new Date(), 0.09, 9, tipP2, bank));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Personal", new Date(), 0.09, 9, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Empresarial", new Date(), 0.01, 10, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Tarjeta de credito", new Date(), 0.15, 11, tipP2, pro.getBank()));
		}).flatMap(pro -> {
			return productRepo
					.save(new CreditProduct("Adelanto Efectivo", new Date(), 0.15, 12, tipP2, pro.getBank()));
		}).subscribe();

		.thenMany(
				Flux.just(new CreditProduct("Personal", new Date(), 0.09, tipP2),
						new CreditProduct("Empresarial",  new Date(), 0.1, tipP2),
						new CreditProduct("Tarjeta de credito", new Date(),0.15, tipP2),
						new CreditProduct("Adelanto Efectivo", new Date(),0.15, tipP2)
						)
				).flatMap(pro -> productRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	*/
	}
}
