package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oder_detail")
public class OrderDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "user_order_id")
	private int orderId;
	@Column(name = "quantity")
	private double quantity;
	@Column(name = "status")
	private int status;
	@Column(name="total_money_product")
	private double totalMoneyProduct;

	public OrderDetailEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public double getTotalMoneyProduct() {
		return totalMoneyProduct;
	}

	public void setTotalMoneyProduct(double totalMoneyProduct) {
		this.totalMoneyProduct = totalMoneyProduct;
	}


	

}
