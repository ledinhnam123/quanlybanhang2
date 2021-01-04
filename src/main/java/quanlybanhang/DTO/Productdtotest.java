package quanlybanhang.DTO;

import quanlybanhang.Entity.ProductEntity;

public class Productdtotest {

	private int id;
	private String productName;
	private double price;
	private int categoryId;

	private int quanty;
	public Productdtotest() {
		
	}
	public Productdtotest(ProductEntity product) {
		
		this.id = product.getId();
		this.productName = product.getProductName();
		
		this.quanty = product.getQuanty();
		this.price = product.getPrice();
		this.categoryId = product.getCategoryId();
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	
	
}
