package quanlybanhang.DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.OrderDetailRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Response.OrderRespone;

@Component
public class OrderDetailDAO {
	
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	public OrderDetailEntity saveOrderDertail(OrderDetailDTO orDTO) {
		OrderDetailEntity ord = OrderDetailDTO.mapperToEntity(orDTO);
		return orderDetailRepository.saveAndFlush(ord);
	}
	
	public OrderDetailEntity save(int orderId, int productId, double quantity) {
		OrderDetailEntity ord = new  OrderDetailEntity();
		ord.setOrderId(orderId);
		ord.setProductId(productId);
		ord.setQuantity(quantity);
		return orderDetailRepository.saveAndFlush(ord);
	}
	
	@Transactional
	public boolean addnNewOrderDetail(int orderId, List<ProductOrderRequest> request) {
		
		for(ProductOrderRequest pro: request) {
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			orderDetail.setProductId(pro.getProductId());
			orderDetail.setOrderId(orderId);
			orderDetail.setQuantity(pro.getQty());
			
			orderDetail = orderDetailRepository.saveAndFlush(orderDetail);
			if(orderDetail == null) {
				return false;
			}
		}
		
		return true;
//		request.forEach(x ->{
//			OrderDetailEntity orderDetail = new OrderDetailEntity();
//			orderDetail.setProductId(x.getProductId());
//			orderDetail.setOrderId(orderId);
//			orderDetail.setQuantity(x.getQty());
//			
//			orderDetailRepository.saveAndFlush(orderDetail);
//		});
		
	}
	
	
	public OrderRespone  findByIdOrder(int orderId) {
		List<OrderDetailEntity> orderDetailEntity = orderDetailRepository.findByOrderId(orderId);
		
		double totalPrice = orderDetailEntity.stream(). mapToDouble(x ->{
			ProductEntity product = productRepository.findById(x.getProductId()).orElse(null);
			if(product!=null) {
				return product.getPrice() * x.getQuantity();
			}
			return 0;
		}).sum();
		
		OrderRespone orderRespone  = new OrderRespone();
		orderRespone.setOrderId(orderDetailEntity.get(0).getOrderId());
		orderRespone.setTotalPrice(totalPrice);
		orderRespone.setProductsOrder(orderDetailEntity.stream().map(product->{
			OrderRespone.ListProductOrder res = new OrderRespone().new ListProductOrder();
			res.setProductName(productRepository.findById(product.getProductId()).get().getProductName());
			res.setQuantity(product.getQuantity());
			return res;
		}).collect(Collectors.toList()));	
		return orderRespone;
	}
	 
	
	public List<OrderDetailEntity> findById(int orderId){
		return orderDetailRepository.findByOrderId(orderId);
	}
	
	public double ToTalPrice(int orderId, List<OrderDetailEntity> listOrder) {
		
		return 0;
	}
	
	
	
	
	
	
}
