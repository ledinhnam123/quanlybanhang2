package quanlybanhang.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.MessageEntity;
import quanlybanhang.Entity.UserEntity;
import quanlybanhang.Entity.UserNotifiCationEntity;
import quanlybanhang.Rebository.MessageRepository;
import quanlybanhang.Rebository.UserNotifiCationRepository;
import quanlybanhang.Rebository.UserRepository;
import quanlybanhang.Request.MessageRequest;

@Component
public class AdmindSendMessageDAO {

	@Autowired
	private UserNotifiCationRepository userNotiRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MessageRepository messRepo;
	Date date1 = new Date();

	public boolean sendMessage(List<MessageRequest> request) {

		for (MessageRequest listMessage : request) {

			UserNotifiCationEntity userNotiEntity = new UserNotifiCationEntity();
			MessageEntity mess = new MessageEntity();

			UserEntity user = userRepo.findOne(listMessage.getUserId());
			if (user != null) {

				userNotiEntity.setUserId(listMessage.getUserId());
				userNotiEntity.setType(1);
				userNotiEntity.setCreateDate(date1);
				userNotiEntity = userNotiRepo.saveAndFlush(userNotiEntity);

				if (userNotiEntity != null) {
					mess.setNotifiId(userNotiEntity.getId());
					mess.setMessage(listMessage.getMessage());
					mess = messRepo.saveAndFlush(mess);

				} else {
					return false;
				}
			} else {
				return false;
			}

		}

		return true;

	}

//send ALl user
	public boolean sendMessAllUser(String message) {

		
		List<UserEntity> allUser = userRepo.findAll();

		for (int i = 0; i < allUser.size(); i++) {
			
			UserNotifiCationEntity userNoti = new UserNotifiCationEntity();
			userNoti.setCreateDate(date1);
			userNoti.setType(1);
			userNoti.setUserId(allUser.get(i).getId());
			
			userNoti =userNotiRepo.saveAndFlush(userNoti);
			if(userNoti!=null) {
				MessageEntity mess = new MessageEntity();
				mess.setMessage(message);
				mess.setNotifiId(userNoti.getId());
				mess = messRepo.saveAndFlush(mess);
			}
			else {
				return false;
			}

		}

		return true;
	}
}
