package com.productocredito.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productocredito.app.business.IProductoService;
import com.productocredito.app.models.ProductoCredito;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;

	@GetMapping
	public Flux<ProductoCredito> listarAllClientes() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<ProductoCredito> buscarCliente(@PathVariable String id) {
		return productoService.finById(id);
	}

	@PostMapping
	public Mono<ProductoCredito> registrarCliente(@RequestBody ProductoCredito producto) {
		return productoService.save(producto);
	}

	@PutMapping
	public Mono<ProductoCredito> actualizarCliente(@RequestBody ProductoCredito producto) {
		return productoService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return productoService.deleteById(id);
	}
}
