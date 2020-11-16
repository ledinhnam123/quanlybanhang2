package quanlybanhang.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.AdmindSendMessageDAO;
import quanlybanhang.DAO.NotifiCationDAO;
import quanlybanhang.Request.MessageRequest;
import quanlybanhang.Response.ListNotifyResponse;
import quanlybanhang.Response.NotificationResponse;
import quanlybanhang.Service.UserNotificationService;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {
	
	@Autowired
	private NotifiCationDAO notifiDao;
	@Autowired
	private AdmindSendMessageDAO adminsendMessage;

	@Override
	public NotificationResponse findByIdUserId(int userId) {
		
		return notifiDao.findByIdUserId(userId);
	}

	@Override
	public ListNotifyResponse getNotificationById(int id, int userId) {
		
		return notifiDao.getNotificationById(id, userId);
	}

	@Override
	public boolean sendMessage(List<MessageRequest> request) {
		
		return adminsendMessage.sendMessage(request);
	}



	

}
