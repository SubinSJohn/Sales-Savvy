package sales.savvy.dto;


public class CartData {
	
	String userName;
	Long productId;
	int quantity;
	public String getUserName() {
		return userName;
	}
	public void setUserId(String userName) {
		this.userName = userName;
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
		return "CartData [userId=" + userName + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
