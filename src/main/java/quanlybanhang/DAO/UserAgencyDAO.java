package quanlybanhang.DAO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Rebository.UserAgencyRepository;
@Transactional
@Component
public class UserAgencyDAO {

	@Autowired
	private UserAgencyRepository userAgencyRepo;
	
	public UserAgencyEntity checkAccount(String userName, String password) {
		
		
		UserAgencyEntity useragency = userAgencyRepo.finUserAgencyByNameAndPassword(userName, password);
		if(useragency != null) {
			return useragency;
		}
		else {
			return null;
		}
	}
	

}
