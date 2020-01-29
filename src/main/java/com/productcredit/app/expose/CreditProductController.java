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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Credit Product Microservice")
@RequestMapping("/products")
public class CreditProductController {
	@Autowired
	private ICreditProductService productService;

	@GetMapping
	@ApiOperation(value = "List all products", notes="Find all products, products contains product's type")
	public Flux<CreditProduct> findAllProducts() {
		return productService.findAll();
	}

	@GetMapping("/bank/{idBank}")
	@ApiOperation(value = "Find products", notes="Find all products by id Bank")
	public Flux<CreditProduct> findAllProductsByIdBank(@PathVariable String idBank) {
		return productService.buscarPorCodigoBanco(idBank);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find a product", notes="Find product by id")
	public Mono<CreditProduct> findProduct(@PathVariable String id) {
		return productService.finById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save a product", notes="Save and return a product, need bank and product type reference")
	public Mono<CreditProduct> saveProduct(@RequestBody CreditProduct producto) {
		return productService.save(producto);
	}

	@PutMapping
	@ApiOperation(value = "Update a product", notes="Update and return a product, need bank and product type reference")
	public Mono<CreditProduct> updateProduct(@RequestBody CreditProduct producto) {
		return productService.save(producto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a product", notes="Delete a product by id")
	public Mono<Void> deleteProduct(@PathVariable String id) {
		return productService.deleteById(id);
	}
}
