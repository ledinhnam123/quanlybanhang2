package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import quanlybanhang.DTO.OrderDTO;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;

@Service
public interface OrderService {

	public OrderEntity AddOder(OrderDTO orderDTO);
	public OrderEntity saveOrder( int userId);
	
	public OrderEntity addOder(OrderManyProductRequest request);
	
	public boolean createNewOrder(int userId, List<ProductOrderRequest> listProducts);
}
