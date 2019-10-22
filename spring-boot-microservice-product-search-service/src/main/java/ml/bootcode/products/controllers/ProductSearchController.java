package ml.bootcode.products.controllers;

import java.util.Collection;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.products.model.Product;
import ml.bootcode.products.service.ProductSearchService;

@RestController
@RefreshScope
public class ProductSearchController {

	private ProductSearchService productSearchService;

	public ProductSearchController(ProductSearchService productSearchService) {
		this.productSearchService = productSearchService;
	}

	@GetMapping("/products/{id}")
	public Product findById(@PathVariable Long id) {
		return productSearchService.findById(id);
	}

	@GetMapping("/products")
	public Collection<Product> findAll() {
		return productSearchService.findAll();
	}
}
