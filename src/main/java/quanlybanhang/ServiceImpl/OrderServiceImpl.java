package quanlybanhang.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.OrderDAO;
import quanlybanhang.DTO.OrderDTO;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Service.OrderService;
@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private OrderDetailServiceImpl orderDetailServiceImpl;
	@Override
	public OrderEntity AddOder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity saveOrder(int userId) {
		return orderDao.saveOrder(userId);
	}

	@Override
	public OrderEntity addOder(OrderManyProductRequest request) {
		try {
			
			OrderEntity order = orderDao.saveOrder(request.getUserId());
			if(order !=null) {
				orderDetailServiceImpl.addnNewOrderDetail(order.getId(), request.getListProducts());
				return order;
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public boolean createNewOrder(int userId, List<ProductOrderRequest> listProducts) {
		return orderDao.createNewOrder(userId, listProducts);
	}
	

}
