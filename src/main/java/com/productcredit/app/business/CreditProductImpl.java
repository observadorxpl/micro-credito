package com.productcredit.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.productcredit.app.models.Bank;
import com.productcredit.app.models.CreditProduct;
import com.productcredit.app.repository.ICreditProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CreditProductImpl implements ICreditProductService{
	
	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;
	
	@Autowired
	private ICreditProductRepository productoRepo;
	
	@Override
	public Flux<CreditProduct> findAll() {
		return productoRepo.findAll();
	}

	@Override
	public Mono<CreditProduct> finById(String id) {
		return productoRepo.findById(id);
	}

	@Override
	public Mono<CreditProduct> save(CreditProduct t) {
		return productoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(CreditProduct t) {
		return productoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return productoRepo.deleteById(id);
	}
	@Override
	public Flux<CreditProduct> buscarPorCodigoBanco(String idBank) {
		return WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get().uri(idBank)
				.retrieve().bodyToMono(Bank.class).log().flatMapMany(bank -> {
					return productoRepo.findByBank(bank);
				});
	}
	
}