package quanlybanhang.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_s1_product")
public class OrderS1ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "order_s1_id")
	private int OrderS1Id;
	@Column(name="product_id")
	private int productId;
	@Column(name="product_quanty")
	private int productQuanty;
	@Column(name="product_price")
	private double productPrice;
	@Column(name="total_money")
	private double totalMoney;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="update_time")
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderS1Id() {
		return OrderS1Id;
	}

	public void setOrderS1Id(int orderS1Id) {
		OrderS1Id = orderS1Id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductQuanty() {
		return productQuanty;
	}

	public void setProductQuanty(int productQuanty) {
		this.productQuanty = productQuanty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
