package quanlybanhang.DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;
import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.OrderDetailRepository;
import quanlybanhang.Rebository.OrderRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Response.OrderRespone;
import quanlybanhang.enumm.LoaiKhachHang;

@Component
public class OrderDetailDAO {
	
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	
	public OrderDetailEntity saveOrderDertail(OrderDetailDTO orDTO) {
		OrderDetailEntity ord = OrderDetailDTO.mapperToEntity(orDTO);
		return orderDetailRepository.saveAndFlush(ord);
	}
	
	public OrderDetailEntity save(int orderId, int productId, double quantity, int status) {
		OrderDetailEntity ord = new  OrderDetailEntity();
		ord.setOrderId(orderId);
		ord.setProductId(productId);
		ord.setQuantity(quantity);
		ord.setStatus(status);
		return orderDetailRepository.saveAndFlush(ord);
	}
	//userID
	
	
	//tạo
	@Transactional
	public double addnNewOrderDetail(int  orderId, List<ProductOrderRequest> request,int  userType) {
		try {
			
			double totalMoney=0;
			double VAT = this.getVAT(userType);
			if(VAT == -1)
				return 0;
			
			for(ProductOrderRequest pro: request) {
				OrderDetailEntity orderDetail = new OrderDetailEntity();
				orderDetail.setOrderId(orderId);
				orderDetail.setProductId(pro.getProductId());
				ProductEntity product = productRepository.findOne(pro.getProductId());
				double total= product.getPrice()*pro.getQty() - product.getPrice()*pro.getQty()*VAT;
				orderDetail.setTotalMoneyProduct(total);
				orderDetail.setQuantity(pro.getQty());
				orderDetail = orderDetailRepository.saveAndFlush(orderDetail);
				totalMoney+=total;
				
				if(orderDetail == null) {
					return 0;
				}
			}
			
			
			return totalMoney;
			
		}
		catch (Exception e) {
			return 0;	
		}

	}
	
	
	//hiển thị chi tiết đơn hàng
	public OrderRespone  findByIdOrder(  int  orderId) {
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
		orderRespone.setStatus(orderDetailEntity.get(1).getStatus());
		orderRespone.setTotalPrice(totalPrice);
		orderRespone.setProductsOrder(orderDetailEntity.stream().map(product->{
			OrderRespone.ListProductOrder res = new OrderRespone().new ListProductOrder();
			res.setProductName(productRepository.findById(product.getProductId()).get().getProductName());
			
			res.setQuantity(product.getQuantity());
			res.setTotalPriceProduct(product.getTotalMoneyProduct());
			return res;
		}).collect(Collectors.toList()));	
		return orderRespone;
	}

	
	public double getVAT(int userType) {
		
		if(userType==LoaiKhachHang.KIMCUONG.getCode()) {
			return 0.2;
		}
		else if(userType==LoaiKhachHang.VANG.getCode()){
			return 0.1;
		}
		else if(userType==LoaiKhachHang.BAC.getCode()){
			return 0.05;
		}
		else if (userType==LoaiKhachHang.NGUOIDUNG.getCode()){
			return 0;
		}
		else return -1;
		
		
	}
	//save Order
	JSONObject saveOrder( int userId) {
		JSONObject js = new JSONObject();
		
		try {
			OrderEntity order = new OrderEntity();
			order.setUserId(userId);
			order = orderRepository.saveAndFlush(order);
			js.put("Order", order);
		} catch (Exception e) {
			
			js.put("Error", "Lỗi ở OrderDetailDao");
			
		}
		
		return js;
	}
	
	
}


