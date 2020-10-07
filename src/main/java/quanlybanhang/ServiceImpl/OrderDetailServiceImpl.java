package quanlybanhang.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.OrderDetailDAO;
import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.OrderDetailRepository;
import quanlybanhang.Rebository.OrderRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Response.OrderRespone;
import quanlybanhang.Service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	private OrderRepository orderRipository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailrepository;
	
	
	@Override
	public OrderDetailEntity saveOrderDertail(OrderDetailDTO orDTO) {
	
		return orderDetailDAO.saveOrderDertail(orDTO);
	}


	@Override
	public OrderDetailEntity save(int orderId, int productId, double quantity) {
		
		List<OrderEntity> od = orderRipository.findById(orderId);
		Optional<ProductEntity> pr = productRepository.findById(productId);
		
		if(od != null && pr!= null) {
		return orderDetailDAO.save(orderId, productId, quantity);
		}
		return null;
		//bool exist = list.Any(item => item == "blue");
		
		
	}
//chinh sua sau
	/*public OrderDetailEntity createNewOrder(OrderManyProductRequest request) {
		OrderEntity order = new OrderEntity();
		order.setUserId(request.getUserId());
		order = orderRipository.saveAndFlush(order);
		final int orderId = order.getId();
		
			request.getListProducts().forEach(product ->{
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			orderDetail.setOrderId(orderId);
			orderDetail.setProductId(product.getProductId());
			orderDetail.setQuantity(product.getQty());
			
			orderDetailrepository.saveAndFlush(orderDetail); 
			
		});
			return null; 
		
	}*/


	@Override
	public boolean addnNewOrderDetail(int orderId, List<ProductOrderRequest> request) {
		return orderDetailDAO.addnNewOrderDetail(orderId, request);
		
	}


	@Override
	public OrderRespone findByIdOrder(int orderId) {
		
		return orderDetailDAO.findByIdOrder(orderId);
	}

}
