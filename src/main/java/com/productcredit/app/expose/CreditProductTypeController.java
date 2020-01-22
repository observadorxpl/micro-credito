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

import com.productcredit.app.business.ICreditProductTypeService;
import com.productcredit.app.models.CreditProductType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products-type")
public class CreditProductTypeController {
	@Autowired
	private ICreditProductTypeService productTypeService;

	@GetMapping
	public Flux<CreditProductType> findAllProductsType() {
		return productTypeService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<CreditProductType> findProductType(@PathVariable String id) {
		return productTypeService.finById(id);
	}

	@PostMapping
	public Mono<CreditProductType> saveProductType(@RequestBody CreditProductType productType) {
		return productTypeService.save(productType);
	}

	@PutMapping
	public Mono<CreditProductType> updateProductType(@RequestBody CreditProductType productType) {
		return productTypeService.save(productType);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteProductType(@PathVariable String id){
		return productTypeService.deleteById(id);
	}
}
