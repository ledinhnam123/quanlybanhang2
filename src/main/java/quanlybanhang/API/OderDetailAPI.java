package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DTO.OrderDetailDTO;
import quanlybanhang.Entity.OrderDetailEntity;
import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.ServiceImpl.OrderDetailServiceImpl;

@RestController
@RequestMapping("OderDetail")
public class OderDetailAPI {

	
	@Autowired
	private OrderDetailServiceImpl orderDetailImpl;
	
	
	@PostMapping("/api/create_ORD")
	public OrderDetailEntity addOrDerDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
		
		return orderDetailImpl.saveOrderDertail(orderDetailDTO);
	}
	
	@PostMapping("/api/test_create")
	public ResponseEntity<?> AddNewDetail(@RequestBody OrderManyProductRequest request) {
		 
		 return null;
	}
	
	@GetMapping("api/Order_Detail")
	public ResponseEntity<?> GetOrderDetail(@RequestParam ("orderId")int orderId){
		return ResponseEntity.ok(orderDetailImpl.findByIdOrder(orderId));
	}
	
	
}
