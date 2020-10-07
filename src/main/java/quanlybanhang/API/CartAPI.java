package quanlybanhang.API;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DTO.CartDTO;
import quanlybanhang.ServiceImpl.CartServiceImpl;
import quanlybanhang.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("Cart")
public class CartAPI {

	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	@Autowired 
	private ProductServiceImpl productImpl;
	
	
	HashMap<Integer, CartDTO> cart = new  HashMap<Integer, CartDTO>();
	
	@PostMapping("api/create_cart")
	@ResponseBody
	public String AddCart( HashMap<Integer, CartDTO> cart ){
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
}
