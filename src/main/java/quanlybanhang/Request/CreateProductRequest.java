package quanlybanhang.Request;

import java.util.List;

public class CreateProductRequest {
	private int id;
	private AccountRequest account;
	private List<ProductRequest> listProduct;
	
	public List<ProductRequest> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<ProductRequest> listProduct) {
		this.listProduct = listProduct;
	}
	public AccountRequest getAccount() {
		return account;
	}
	public void setAccount(AccountRequest account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
