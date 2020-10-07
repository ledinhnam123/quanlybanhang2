package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.DTO.CartDTO;
import quanlybanhang.DTO.OrderDTO;
import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Entity.OrderEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.OrderDetailRepository;
import quanlybanhang.Rebository.OrderRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Request.ProductOrderRequest;

@Component
public class OrderDAO {


	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderDetailDAO orderDetailDao;
	 @Autowired
	 private ProductDAO  productDao;
	 @Autowired
	 private ProductRepository productRepository;

	

	
	public OrderEntity saveOrder( int userId) {
		
		OrderEntity order = new OrderEntity();
		order.setUserId(userId);
		
		return orderRepository.saveAndFlush(order);
	}
	
	
	public boolean createNewOrder(int userId, List<ProductOrderRequest> listProducts) {
		OrderEntity order = saveOrder(userId);
		if(order != null) {
			orderDetailDao.addnNewOrderDetail(order.getId(), listProducts);
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	
	public List<OrderDTO> findByUser(int userId) {
		
		List<OrderEntity> oders = orderRepository.findByUserId(userId);
		List<OrderDTO> lists= new ArrayList<OrderDTO>();
		for(OrderEntity order: oders) {
			OrderDTO orderDTO =  OrderDTO.mapperToDTO(order);
			lists.add(orderDTO);
		}
		return lists;
	}
	
	 public OrderEntity  findUserOrderById(int userId, int orderId){
	        return orderRepository.findByIdAndUserId(orderId,userId).orElse(null);// ko duoc null
	    }
	/*
	 * public OderRespone save(OrderRequest req) {
	 * 
	 * 
	 * OderEntity order = new OderEntity(); OderDTO dto = new OderDTO();
	 * ProductEntity pro = prodcuctRepository.findOne(req.getProductId()); if(pro
	 * !=null) { dto.setProductName(pro.getProductName()); }
	 * 
	 * //order.setProductId(rseq.getProductId());
	 * 
	 * order.setQuantily(req.getQuantity()); order = oderRepository.save(dto);
	 * //return oderRepository.saveAndFlush(order); OderRespone oderRes = new
	 * OderRespone(); oderRes.setId(order.getId());
	 * oderRes.setProductName(pro.getProductName());
	 * oderRes.setQuantity(req.getQuantity()); return oderRes;
	 * 
	 * }
	 */

	/*
	 * @Autowired private OderRepository repository;
	 * 
	 * public UserOderEntity addNewOderDao(Integer userId){ UserOderEntity
	 * userOderEntity = new UserOderEntity(); userOderEntity.setUserId(userId);
	 * return repository.saveAndFlush(userOderEntity); }
	 * 
	 * public UserOderEntity findUserOderById(Integer userId, Integer orderId){
	 * return repository.findByIdAndUserId(orderId,userId).orElse(null); }
	 */
	 
	 public double TotalPrice(int orderId,List<OrderDetailDAO> orderDetail) {
			
			OrderDetailEntity order = orderDetailRepository.findOne(orderId);
			ProductEntity product = new  ProductEntity();
			OrderDetailDAO orderDAO = new OrderDetailDAO();
			if(orderDAO!=null) {
				
			}
				//totalPrice+= itemCart.getValue().getTotalPrice();
	 
			
			return 0;
		}
	/* public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {

			CartDTO itemCart = new CartDTO();
			ProductDTO product = productDao.findOne(id);
			if (product != null) {
				itemCart.setProductDTO(product);
				itemCart.setQuantily(1);
				itemCart.setTotalPrice(product.getPrice());
			}
			cart.put(id, itemCart);
			return cart;
		}*/
	
	


}
