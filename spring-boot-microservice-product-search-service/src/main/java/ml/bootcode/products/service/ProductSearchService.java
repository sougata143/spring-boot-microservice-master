package ml.bootcode.products.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import ml.bootcode.products.model.Product;

@Service
public class ProductSearchService {

	private static Map<Long, Product> productRepository = null;

	static {
		Stream<String> productStream = Stream
				.of("1,Nokia 6.1 Plus,Dual Sim Android Smartphone,Mobile,Nokia,16000",
						"2,Nokia 7.1,Dual Sim Android Smartphone,Mobile,Nokia,19000",
						"3,Nokia 8.1,Dual Sim Android Smartphone,Mobile,Nokia,26000");
		
		productRepository = productStream.map(productString -> {
			String[] info = productString.split(",");
			return createProduct(new Long(info[0]), info[1], info[2], info[3], info[4], new Integer(info[5]));
		}).collect(Collectors.toMap(Product::getProductId, prod -> prod));
	}

	private static Product createProduct(Long id, String name, String desc, String category, String brand,
			int price) {
		Product product = new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setProductDescription(desc);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);

		return product;
	}

	public Product findById(Long id) {
		return productRepository.get(id);
	}

	public Collection<Product> findAll() {
		return productRepository.values();
	}
}
