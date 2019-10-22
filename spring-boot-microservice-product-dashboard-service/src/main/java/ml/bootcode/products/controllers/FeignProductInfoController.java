package ml.bootcode.products.controllers;

import java.util.Collection;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.products.models.ProductInfo;

@RefreshScope
@RestController
public class FeignProductInfoController {

	private ProductServiceProxy proxyService;

	public FeignProductInfoController(ProductServiceProxy proxyService) {
		this.proxyService = proxyService;
	}

	@GetMapping("/dashboard/feign/{myself}")
	public ProductInfo findMe(@PathVariable Long myself) {
		return proxyService.findById(myself);
	}

	@GetMapping("/dashboard/feign/peers")
	public Collection<ProductInfo> findAll() {
		return proxyService.findAll();
	}
}
