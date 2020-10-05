package quanlybanhang.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import quanlybanhang.DTO.CartDTO;

@Service
public interface CartService {
	 public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart);
	 public HashMap<Integer, CartDTO> EditCart(int id, double quantily, HashMap<Integer, CartDTO> cart);
	 public HashMap<Integer, CartDTO> DeleteCart(int id, double quantily, HashMap<Integer, CartDTO> cart);
	 public double TotalPrice(HashMap<Integer, CartDTO> cart);
	 public double TotalQuantily( HashMap<Integer, CartDTO> cart) ;
	
}
