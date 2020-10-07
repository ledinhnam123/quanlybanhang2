package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Response.OrderRespone;


@Service
public interface OrderDetailService {

	
	public OrderDetailEntity saveOrderDertail(OrderDetailDTO orDTO);
	
	public OrderDetailEntity save(int orderId, int productId, double quantity);
	
	public boolean addnNewOrderDetail(int orderId, List<ProductOrderRequest> request);
	
	public OrderRespone  findByIdOrder(int orderId);
	
}

