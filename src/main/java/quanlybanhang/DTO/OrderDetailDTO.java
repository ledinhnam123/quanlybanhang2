package quanlybanhang.DTO;

import org.modelmapper.ModelMapper;

import quanlybanhang.Entity.OrderDetailEntity;

public class OrderDetailDTO {

	private int id;
	private int orderId;
	private int productId;
	private double quantity;
	private double totalPrice;
	//totalPrice = quantity(order)*Product.getPrice
	public OrderDetailDTO() {

	}
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public double getQuantity() {
		return quantity;
	}




	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}




	public double getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}




	//DB lên
	public static OrderDetailDTO mapperToDTO( OrderDetailEntity orderDetailEntity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(orderDetailEntity, OrderDetailDTO.class);
	}

	// DL từ client truyền xuống
	public static OrderDetailEntity mapperToEntity(OrderDetailDTO orderDetailDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(orderDetailDTO, OrderDetailEntity.class);
	}

}
