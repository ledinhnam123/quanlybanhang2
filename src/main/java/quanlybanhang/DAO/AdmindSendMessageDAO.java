package quanlybanhang.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.UserEntity;
import quanlybanhang.Entity.UserNotifiCationEntity;
import quanlybanhang.Rebository.UserNotifiCationRepository;
import quanlybanhang.Rebository.UserRepository;
import quanlybanhang.Request.MessageRequest;

@Component
public class AdmindSendMessageDAO {

	@Autowired
	private UserNotifiCationRepository userNotiRepo;
	@Autowired
	private UserRepository userRepo;

	public boolean sendMessage( List<MessageRequest> request) {

	
		for (MessageRequest listMessage : request) {
			
			UserNotifiCationEntity userNotiEntity = new UserNotifiCationEntity();
			
			UserEntity user = userRepo.findOne(listMessage.getUserId());
				if(user!=null) {
					userNotiEntity.setUserId(listMessage.getUserId());
					userNotiEntity.setMessage(listMessage.getMessage());
					userNotiEntity.setType(1);
					
					userNotiEntity = userNotiRepo.saveAndFlush(userNotiEntity);
					
					if(userNotiEntity==null) {
						
						return false;
					}
				}
			
		}
	
		return true;

	}
}
