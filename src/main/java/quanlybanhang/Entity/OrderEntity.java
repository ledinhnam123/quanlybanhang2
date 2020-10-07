package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oder")
public class OderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name ="product_id")
	private String productId;
	
	@Column(name="quantily")
	private double quantily;

	public OderEntity() {
		
	}

	public OderEntity(int id, int userId, String productId, double quantily) {
		
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantily = quantily;
	}


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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getQuantily() {
		return quantily;
	}

	public void setQuantily(double quantily) {
		this.quantily = quantily;
	}
	
	
	
}
