package quanlybanhang.ServiceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.CartDAO;
import quanlybanhang.DTO.CartDTO;
import quanlybanhang.Service.CartService;
 
@Service
public class CartServiceImpl implements CartService {

	 
	@Autowired
	private CartDAO cartDao;
	@Override
	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Integer, CartDTO> EditCart(int id, double quantily, HashMap<Integer, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDao.EditCart(id, quantily, cart);
	}

	@Override
	public HashMap<Integer, CartDTO> DeleteCart(int id, double quantily, HashMap<Integer, CartDTO> cart) {
		
		return DeleteCart(id, quantily, cart);
	}

	@Override
	public double TotalPrice(HashMap<Integer, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDao.TotalPrice(cart);
	}

	@Override
	public double TotalQuantily(HashMap<Integer, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDao.TotalQuantily(cart);
	}

	
}
