package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DTO.OrderDTO;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;

@Service
public interface OrderService {

	public OrderEntity AddOder(OrderDTO orderDTO);
	public OrderEntity saveOrder( int userId);
	
	public JSONObject addOder(OrderManyProductRequest request);
	
	public double createNewOrder(int userId, List<ProductOrderRequest> listProducts);
}
