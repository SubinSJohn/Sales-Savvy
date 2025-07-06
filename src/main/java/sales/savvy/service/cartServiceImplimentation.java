package sales.savvy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.savvy.dto.CartData;
import sales.savvy.dto.CartItemDTO;
import sales.savvy.entity.*;
import sales.savvy.repository.*;

@Service
public class cartServiceImplimentation implements CartService {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	CartItemRepository cartItemRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ProductRepository productRepo;
	
	
	@Override
	public String addToCart(CartData data) {
		String userName = data.getUserName();
		Long productId = data.getProductId();
		int quantity = data.getQuantity();
		
		User user = userRepo.findByusername(userName);
		if(user == null) return "Typed error: No user found with this ID";
		
		Product product = productRepo.findById(productId).orElse(null);
		if(product == null) return "Typed error: No product found with this ID";
		
		Cart cart = user.getCart();
		
		Optional<CartItem> existingItemOpt = cart.getItems().stream()
			    .filter(item -> item.getProduct().getId().equals(productId))
			    .findFirst();
		
		if(existingItemOpt.isPresent()) {
			CartItem cartitem = existingItemOpt.get();
			cartitem.setQuantity(cartitem.getQuantity()+quantity);
			cartItemRepo.save(cartitem);
		} else {
			CartItem cartitem = new CartItem();
			
			cartitem.setCart(cart);
			cartitem.setProduct(product);
			cartitem.setQuantity(quantity);
			cartItemRepo.save(cartitem);
		}

		
		return "Item added to cart";
	}
	
	
	@Override
	public List<CartItemDTO> viewCart(String name) {
		User user = userRepo.findByusername(name);
		if(user == null) throw new RuntimeException("User not found");
	
	    Cart cart = user.getCart();
	    
	    return cart.getItems().stream()
	        .map(item -> new CartItemDTO(item.getProduct().getId(), item.getQuantity()))
	        .collect(Collectors.toList());
	}
	
	
	
	@Override
	public String removeFromCart(CartData data) {
		String userName = data.getUserName();
		Long productId = data.getProductId();
		int quantity = data.getQuantity();
		
		User user = userRepo.findByusername(userName);
		if(user == null) return "Typed error: No user found with this ID";
		
		Product product = productRepo.findById(productId).orElse(null);
		if(product == null) return "Typed error: No product found with this ID";
		
		Cart cart = user.getCart();
		
		Optional<CartItem> existingItemOpt = cart.getItems().stream()
				.filter(item -> item.getProduct().getId().equals(productId))
				.findFirst();
		
		if (existingItemOpt.isPresent()) {
		    CartItem cartItem = existingItemOpt.get();
		    int currentQty = cartItem.getQuantity();

		    if (currentQty > quantity) {
		        cartItem.setQuantity(currentQty - quantity);
		        cartItemRepo.save(cartItem);
		        return "Item removed";
		    } else {
		    	
		    	cart.getItems().remove(cartItem);
		        cartItemRepo.delete(cartItem);
		        return "Item removed completely from cart";
		    }
		} else {
		    return "This product is not in the cart";
		}

	}
	
	@Override
	public String emptyCart(String name) {
	    User user = userRepo.findByusername(name);
	    if (user == null) return "User not found";

	    Cart cart = user.getCart();
	    if (cart == null || cart.getItems().isEmpty()) return "Cart is already empty";

	    cart.getItems().clear();
	    cartRepo.save(cart);
	    return "Cart cleared successfully";
	}
	
	
}



































