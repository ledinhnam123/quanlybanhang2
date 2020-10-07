package quanlybanhang.Response;

import java.util.List;

public class OrderRespone {


	private  int orderId;
	private double totalPrice;
	
	private List<ListProductOrder> productsOrder;
	
	public List<ListProductOrder> getProductsOrder() {
		return productsOrder;
	}



	public void setProductsOrder(List<ListProductOrder> productsOrder) {
		this.productsOrder = productsOrder;
	}



	public OrderRespone() {
		
	}



	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}





	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public class ListProductOrder{
		private String productName;
		private double quantity;
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getQuantity() {
			return quantity;
		}
		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}
		
		
		
	}
}
