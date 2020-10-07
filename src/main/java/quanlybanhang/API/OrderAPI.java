package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.Request.OrderManyProductRequest;
import quanlybanhang.ServiceImpl.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderAPI {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	
	@PostMapping("/api_create_Order")
	public ResponseEntity<?> AddOrder(@RequestBody OrderManyProductRequest request){
		return ResponseEntity.ok(orderServiceImpl.createNewOrder(request.getUserId(), request.getListProducts()));
	}
	
	
	
}
