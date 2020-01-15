package com.productocredito.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.productocredito.app.models.ProductoCredito;
import com.productocredito.app.models.TipoProducto;
import com.productocredito.app.repository.IProductoCreditoRepository;
import com.productocredito.app.repository.ITipoProductoRepository;

import reactor.core.publisher.Flux;
@EnableEurekaClient
@SpringBootApplication
public class ProductosCreditosMsApplication implements CommandLineRunner{
	@Autowired
	private ReactiveMongoTemplate template;
	
	@Autowired
	private IProductoCreditoRepository productoRepo;
	@Autowired
	private ITipoProductoRepository tipoProductoRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductosCreditosMsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(ProductoCredito.class).subscribe();
		template.dropCollection(TipoProducto.class).subscribe();
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		
		TipoProducto tipP2 = new TipoProducto("Creditos");
		Flux.just(tipP2)
		.flatMap(tipP -> tipoProductoRepo.save(tipP))
		.thenMany(
				Flux.just(new ProductoCredito("Personal", new Date(), 0.09, tipP2),
						new ProductoCredito("Empresarial",  new Date(), 0.1, tipP2),
						new ProductoCredito("Tarjeta de credito", new Date(),0.15, tipP2),
						new ProductoCredito("Adelanto Efectivo", new Date(),0.15, tipP2)
						)
				).flatMap(pro -> productoRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	}
}
