package sales.savvy.service;

import java.util.List;

import sales.savvy.entity.Product;

public interface ProductService {

	void addProduct(Product product);

	Product searchProductById(Long id);
	
	List<Product> getAllProducts();

	void updateProduct(Product product);

	void deleteProduct(Long id);
	
}
