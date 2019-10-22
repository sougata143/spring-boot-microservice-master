package ml.bootcode.products.controllers;

import java.util.Collection;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ml.bootcode.products.models.ProductInfo;

@FeignClient(name = "ProductSearch")
@RibbonClient(name = "ProductSearch")
public interface ProductServiceProxy {

	@GetMapping("/products/{id}")
	public ProductInfo findById(@PathVariable(value = "id") Long id);

	@GetMapping("/products")
	public Collection<ProductInfo> findAll();
}
