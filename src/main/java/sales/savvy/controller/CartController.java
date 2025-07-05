package sales.savvy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sales.savvy.dto.CartData;
import sales.savvy.entity.Cart;
import sales.savvy.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody CartData data) {
		return cartService.addToCart(data);
	}
	
	@GetMapping("/viewCart")
	public Cart viewCart(String name) {
		return cartService.viewCart(name);
	}
	
	@PostMapping("/removeFromCart")
	public String removeFromCart(@RequestBody CartData data) {
		return cartService.removeFromCart(data);
	}
	
	@PostMapping("/emptyCart")
	public String emptyCart(@RequestBody String name) {
		return cartService.emptyCart(name);
	}
	
	
	
	
}
