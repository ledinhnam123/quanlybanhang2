package quanlybanhang.DTO;

import org.modelmapper.ModelMapper;

import quanlybanhang.Entity.ProductEntity;

public class ProductDTO {

	private int id;
	private String productName;
	private double price;
	private String categoryName;
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

	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	//DL móc tư csdl lên
	public static ProductDTO mapperToDTO(ProductEntity productEntity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(productEntity, ProductDTO.class);
	}
	
	//DL từ client truyền xuống
	public static ProductEntity mapperToEntity(ProductDTO productDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(productDTO,ProductEntity.class);
	}
	
}
