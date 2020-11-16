package quanlybanhang.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DAO.OrderDAO;
import quanlybanhang.DTO.OrderDTO;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserEntity;
import quanlybanhang.Entity.UserNotifiCationEntity;
import quanlybanhang.Rebository.OrderDetailRepository;
import quanlybanhang.Rebository.OrderRepository;
import quanlybanhang.Rebository.UserNotifiCationRepository;
import quanlybanhang.Rebository.UserRepository;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Service.OrderService;
import quanlybanhang.enumm.LoaiKhachHang;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderDetailServiceImpl orderDetailServiceImpl;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private ProductServiceImpl productServiceIpml;
	@Autowired
	private UserNotifiCationRepository userNotifiCation;

	
	

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
	public JSONObject addOder(OrderManyProductRequest request) {
		JSONObject js = new JSONObject();
		
		try {

			
			OrderEntity order = orderDao.saveOrder(request.getUserId());
			UserEntity user = userRepository.findOne(request.getUserId());
			
			
			String message = "";
			int code = -1;
			if (order != null) {
				// order.setTotalMoneyVat();
				
				double totalMoney = orderDetailServiceImpl.addnNewOrderDetail(order.getId(), request.getListProducts(),
						user.getType());

				if (totalMoney > 0) {

					order.setTotalMoneyOrder(totalMoney);
//					
//					UserEntity user1 = userRepository.findOne(request.getUserId());
//					
//					//khi nò admin duyet thì mới cập nhật total tổng tiền vào level trong bảng user
//					
//				double totalMoneyUser = user1.getLevel() + totalMoney;
//				
//				user1.setLevel(totalMoneyUser);
//				LoaiKhachHang lkh = this.checkUserType(totalMoneyUser);
//
//				user1.setType(lkh.getCode());
//
//			user1 = userRepository.saveAndFlush(user1);
					
					order =orderRepository.saveAndFlush(order);
					if(order!=null) {
//						List<String> listProductsName= request.getListProducts().stream().map(x->{
//							ProductEntity pro = productServiceIpml.finOne(x.getProductId());
//							return pro.getProductName();
//						}).collect(Collectors.toList());
						
						List<String> listProductName = new ArrayList<String>();
						List<ProductOrderRequest> listProducts = request.getListProducts();
						
						for(int i = 0 ; i < listProducts.size() ; i++) {
							ProductOrderRequest proOrder = listProducts.get(i);
							ProductDTO pro = productServiceIpml.getByproducttId(proOrder.getProductId());
							message += "Product " + (i + 1) + ". Product Name: " + pro.getProductName() + ", Quantity: " + proOrder.getQty() + "\n";
							listProductName.add(pro.getProductName());
						}		
						code=1;//order thành công
						UserNotifiCationEntity userNoti = new UserNotifiCationEntity();
						userNoti.setMessage(message);
						userNoti.setCode(code);
						userNoti.setUserId(order.getUserId());
						userNoti =userNotifiCation.saveAndFlush(userNoti);
						js.put("NotifyOrder",userNoti );
					}
					
				}
			
				js.put("AddOrder", order);
				return js;
			}
			return null;
			
			
			
		} catch (Exception e) {
			return null;
		}

	}
	//update Status
	public JSONObject UpdateStatus(int orderId) {
		JSONObject js = new JSONObject();
		try {

			OrderEntity order = orderRepository.getOne(orderId);
			UserEntity user2 = userRepository.finUserByIdOrder(orderId);
			List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findByOrderId(orderId) ;
			
			for(OrderDetailEntity listOrderDetail:orderDetailEntities ) {
				if(listOrderDetail.getStatus()==0) {
					listOrderDetail.setStatus(1);
				 }
				
			   }
	
			 if(order!=null) {
				
				double totalMoneyUsers = user2.getLevel() +  order.getTotalMoneyOrder();
				
				user2.setLevel(totalMoneyUsers);
				LoaiKhachHang lkh = this.checkUserType(totalMoneyUsers);

				user2.setType(lkh.getCode());

				user2 = userRepository.saveAndFlush(user2);
			}
			
			js.put("User", user2);
			
		} catch (Exception e) {
			js.put("Error", "Có lỗi xảy ra!");
		}
		return js;
	}

	@Override
	public double createNewOrder(int userId, List<ProductOrderRequest> listProducts) {
		return orderDao.createNewOrder(userId, listProducts);
	}
// kiem tra giam gia

	public LoaiKhachHang checkUserType(double totalMoney) {

		if (totalMoney >= 0 && totalMoney < 100) {
			return LoaiKhachHang.NGUOIDUNG;
		}

		else if (totalMoney >= 100 && totalMoney < 500) {
			return LoaiKhachHang.BAC;
		} else if (totalMoney >= 500 && totalMoney < 1000) {
			return LoaiKhachHang.VANG;
		} else {
			return LoaiKhachHang.KIMCUONG;
		}
	}

}
