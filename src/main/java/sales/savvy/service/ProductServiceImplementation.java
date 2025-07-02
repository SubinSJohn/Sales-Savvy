package sales.savvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.savvy.entity.Product;
import sales.savvy.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public Product searchProductById(Long id) {
		return productRepo.findById(id).get();
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
		
	}
	
	@Override
	public void updateProduct(Product product) {
		productRepo.save(product);
	}
	
	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

}
