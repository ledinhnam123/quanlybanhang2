package quanlybanhang.Request;

import java.util.List;

public class OrderS1ManyProductRequest {

	private int userAgencyId;
	
	private List<ProductOrderRequest> listProduct;
	
	public int getUserAgencyId() {
		return userAgencyId;
	}
	public void setUserAgencyId(int userAgencyId) {
		this.userAgencyId = userAgencyId;
	}
	public List<ProductOrderRequest> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<ProductOrderRequest> listProduct) {
		this.listProduct = listProduct;
	}
	
	
	
	
}
