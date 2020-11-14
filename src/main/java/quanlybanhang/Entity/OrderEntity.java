package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int userId;
	@Column(name="total_money_order")
	private double totalMoneyOrder;
	@Column(name="total_money_vat")
	private double totalMoneyVat;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalMoneyOrder() {
		return totalMoneyOrder;
	}

	public void setTotalMoneyOrder(double totalMoneyOrder) {
		this.totalMoneyOrder = totalMoneyOrder;
	}

	public double getTotalMoneyVat() {
		return totalMoneyVat;
	}

	public void setTotalMoneyVat(double totalMoneyVat) {
		this.totalMoneyVat = totalMoneyVat;
	}

	


}
