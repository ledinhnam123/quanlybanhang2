package quanlybanhang.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import quanlybanhang.DTO.CartDTO;
import quanlybanhang.DTO.ProductDTO;
 @Component
public class CartDAO {

	// thêm giỏ hàng
	ProductDAO productDao = new ProductDAO();
	
	
	

	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {

		CartDTO itemCart = new CartDTO();
		ProductDTO product = productDao.findOne(id);
		if (product != null) {
			itemCart.setProductDTO(product);
			itemCart.setQuantily(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	// edit Giỏ hàng

	public HashMap<Integer, CartDTO> EditCart(int id, double quantily, HashMap<Integer, CartDTO> cart) {

		//kiểm tra
		if(cart==null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if (cart.containsKey(id)) {

			itemCart = cart.get(id);
			itemCart.setQuantily(quantily);// thay đổi

			// tường minhh hơn
			double totalPrice = quantily * itemCart.getProductDTO().getPrice();
			itemCart.setTotalPrice(totalPrice);
			// itemCart.setTotalPrice(quantily*itemCart.getProductDTO().getPrice());

		}

		cart.put(id, itemCart);
		return cart;
	}

	// xóa
	public HashMap<Integer, CartDTO> DeleteCart(int id, double quantily, HashMap<Integer, CartDTO> cart) {
		
		if(cart==null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}

		return cart;
	}
	
	//tổng số sản phẩm giỏ hàng(cộng dồn)
public double TotalQuantily( HashMap<Integer, CartDTO> cart) {
		double totalQuantily =0;
		for(Map.Entry<Integer, CartDTO> itemCart: cart.entrySet()) {
			totalQuantily+= itemCart.getValue().getQuantily();
		}
		
		return totalQuantily;
	}
//tổng tiền giỏ hàng(cộng dồn)
public double TotalPrice(HashMap<Integer, CartDTO> cart) {
	
	double totalPrice =0;
	for(Map.Entry<Integer, CartDTO> itemCart: cart.entrySet()) {
		totalPrice+= itemCart.getValue().getTotalPrice();
	}
	
	return totalPrice;
}

}
