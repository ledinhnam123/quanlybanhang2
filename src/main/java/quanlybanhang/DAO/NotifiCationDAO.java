package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.UserNotifiCationEntity;
import quanlybanhang.Rebository.UserNotifiCationRepository;
import quanlybanhang.Response.ListNotifyResponse;
import quanlybanhang.Response.NotificationResponse;

@Component
public class NotifiCationDAO {

	@Autowired
	private  UserNotifiCationRepository userNotifiCationRepo;
	
	//FinAllNotify User
	public NotificationResponse findByIdUserId(int userId) {
		List<UserNotifiCationEntity> listUserNotify = userNotifiCationRepo.findNotifyByUserId(userId);
		NotificationResponse res = new NotificationResponse();
		List<ListNotifyResponse> listStatusMessage = new ArrayList<ListNotifyResponse>();
		
		int totalNotiStatus = 0;
		
		for(UserNotifiCationEntity listNoti: listUserNotify ) {
		ListNotifyResponse lisMes = new  ListNotifyResponse();
			lisMes.setStatus(listNoti.getStatusMessage());
			lisMes.setMessage(listNoti.getMessage());
			if(listNoti.getStatusMessage()==0) {	
				totalNotiStatus+=1;
			}	
			listStatusMessage.add(lisMes);
		}
		res.setListNotify(listStatusMessage);
		res.setTotalNotifyNo(totalNotiStatus);
	
		
		return res;
	}
	
	
	//user read notify message
	 public ListNotifyResponse getNotificationById(int id, int userId) {
		 
		 UserNotifiCationEntity useNotify = userNotifiCationRepo.findOne(id);
		 ListNotifyResponse res = new   ListNotifyResponse();
		 if(useNotify.getStatusMessage() == 0) {
			 useNotify.setStatusMessage(1);
			 
		 }
		 res.setStatus(useNotify.getStatusMessage());
		 res.setMessage(useNotify.getMessage());
		 useNotify= userNotifiCationRepo.saveAndFlush(useNotify);
		 return res;
	 }
	
	
}
