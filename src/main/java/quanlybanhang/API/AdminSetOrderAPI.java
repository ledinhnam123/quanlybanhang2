package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.ServiceImpl.OrderServiceImpl;
@RestController
@RequestMapping(value="/api_admin_setStatus")
public class AdminSetOrderAPI {

	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/order")
	public ResponseEntity<?> setOrder(@RequestParam("orderId") int orderId){
		return ResponseEntity.ok(orderServiceImpl.UpdateStatus(orderId));
	}
}
