package sales.savvy.service;


import sales.savvy.dto.CartData;
import sales.savvy.entity.Cart;

public interface CartService {

	public String addToCart(CartData data);
	public Cart viewCart(String name);
	public String removeFromCart(CartData data);
	public String emptyCart(String name);
}
