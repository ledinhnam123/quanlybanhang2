package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import quanlybanhang.Request.MessageRequest;
import quanlybanhang.Response.ListNotifyResponse;
import quanlybanhang.Response.NotificationResponse;

@Service
public interface UserNotificationService {

	public NotificationResponse findByIdUserId(int userId);
	public ListNotifyResponse getNotificationById(int id, int userId);
	
	public boolean sendMessage(List<MessageRequest> request);
}
