package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class ProductEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name= "category_id")
	private int categoryId;
	
	public int getCategoryId() {
		return categoryId;
	}

	
	public ProductEntity() {
		
	}

	public ProductEntity(int id, String productName, double price, int categoryId) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
