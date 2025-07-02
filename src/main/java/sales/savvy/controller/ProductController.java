package sales.savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sales.savvy.entity.Product;
import sales.savvy.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		service.addProduct(product);
		return "Saved";
	}
	
	@GetMapping("/searchProductById")
	public Product searchProductById(Long id) {
		Product product = service.searchProductById(id);
		return product;
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		List<Product> list = service.getAllProducts();
		return list;
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(Product product) {
		service.updateProduct(product);
		return "success";
	}
	
	@PostMapping("/deleteProduct")
	public void deleteProduct(Long id) {
		service.deleteProduct(id);
	}
	
}
