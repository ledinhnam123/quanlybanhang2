package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.Request.AdminSendMessage;
import quanlybanhang.ServiceImpl.UserNotificationServiceImpl;

@RestController
@RequestMapping("/admin_sendMessage")
public class AdminSendMessageAPI {

	
	@Autowired
	private UserNotificationServiceImpl userNotifiServiceImpl;
	
	@PostMapping("/api/user_notify")
	public ResponseEntity<?> addOrDerDetail(@RequestBody AdminSendMessage request ) {
		
		return ResponseEntity.ok(userNotifiServiceImpl.sendMessage(request.getListMess()));
	}
	
	
}
