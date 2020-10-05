package quanlybanhang.API;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DTO.CartDTO;
import quanlybanhang.ServiceImpl.CartServiceImpl;

@RestController
@RequestMapping("Cart")
public class CartAPI {

	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	
	HashMap<Integer, CartDTO> cart = new  HashMap<Integer, CartDTO>();
	
	@PostMapping("api/create_cart")
	@ResponseBody
	public HashMap<Integer, CartDTO> AddCart(@RequestParam  int id , HashMap<Integer, CartDTO> cart ){
		
		
		return cartServiceImpl.AddCart(id, cart);
		
	}
}
