package quanlybanhang.Request;

import java.util.List;

public class OrderManyProductRequest {

	private int userId;
	private List<ProductOrderRequest> listProducts;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<ProductOrderRequest> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<ProductOrderRequest> listProducts) {
		this.listProducts = listProducts;
	}
	
	
}
