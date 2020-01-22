package com.productcredit.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcredit.app.business.ICreditProductService;
import com.productcredit.app.models.CreditProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class CreditProductController {
	@Autowired
	private ICreditProductService productService;

	@GetMapping
	public Flux<CreditProduct> findAllProducts() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<CreditProduct> findProduct(@PathVariable String id) {
		return productService.finById(id);
	}

	@PostMapping
	public Mono<CreditProduct> saveProduct(@RequestBody CreditProduct producto) {
		return productService.save(producto);
	}

	@PutMapping
	public Mono<CreditProduct> updateProduct(@RequestBody CreditProduct producto) {
		return productService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return productService.deleteById(id);
	}
}
