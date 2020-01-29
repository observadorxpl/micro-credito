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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Credit Product Microservice")
@RequestMapping("/products-type")
public class CreditProductTypeController {
	@Autowired
	private ICreditProductTypeService productTypeService;

	@GetMapping
	@ApiOperation(value = "List all product's types", notes="Find all product's types")
	public Flux<CreditProductType> findAllProductsType() {
		return productTypeService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find a product's type", notes="Find a product's type by id")
	public Mono<CreditProductType> findProductType(@PathVariable String id) {
		return productTypeService.finById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save a product's type", notes="Save and return a product's type")
	public Mono<CreditProductType> saveProductType(@RequestBody CreditProductType productType) {
		return productTypeService.save(productType);
	}

	@PutMapping
	@ApiOperation(value = "Update a product's type", notes="Update and return a product's type")
	public Mono<CreditProductType> updateProductType(@RequestBody CreditProductType productType) {
		return productTypeService.save(productType);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a product's type", notes="Delete a product's type by id")
	public Mono<Void> deleteProductType(@PathVariable String id){
		return productTypeService.deleteById(id);
	}
}
