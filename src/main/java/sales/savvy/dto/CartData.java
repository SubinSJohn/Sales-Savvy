package sales.savvy.dto;


public class CartData {
	
	Long userId;
	Long productId;
	int quantity;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartData [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
