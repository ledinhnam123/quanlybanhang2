package quanlybanhang.DTO;

public class CartDTO {
	
	private double quantily;
	private double totalPrice;
	private ProductDTO productDTO;
	public CartDTO() {
	
	}
	
	public CartDTO(double quantily, double totalPrice, ProductDTO productDTO) {
		super();
		this.quantily = quantily;
		this.totalPrice = totalPrice;
		this.productDTO = productDTO;
	}
	public double getQuantily() {
		return quantily;
	}
	public void setQuantily(double quantily) {
		this.quantily = quantily;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
		
	
	
	
	

}
