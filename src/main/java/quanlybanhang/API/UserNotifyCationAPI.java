package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.ServiceImpl.UserNotificationServiceImpl;

@RestController
@RequestMapping("/api_notify")
public class UserNotifyCationAPI {
@Autowired
private  UserNotificationServiceImpl usernotiServiImpl;



	@GetMapping("/get_all_notify")
	public ResponseEntity<?> getAllNotify(@RequestParam("userId") int userId){
		return ResponseEntity.ok(usernotiServiImpl.findByIdUserId(userId));
	}
	
	@GetMapping("/get_notifyById")
	public ResponseEntity<?> getByIdNotify(@RequestParam("id") int id,@RequestParam("userId") int userId){
		return ResponseEntity.ok(usernotiServiImpl.getNotificationById(id, userId)); 
	}
	
}
