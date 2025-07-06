package sales.savvy.service;


import java.util.List;

import sales.savvy.dto.CartData;
import sales.savvy.dto.CartItemDTO;

public interface CartService {

	public String addToCart(CartData data);
	public List<CartItemDTO> viewCart(String name);
	public String removeFromCart(CartData data);
	public String emptyCart(String name);
}
