package quanlybanhang.Service;

import org.springframework.stereotype.Service;

import quanlybanhang.Entity.UserAgencyEntity;
@Service
public interface UserAgencyService {
	
	public UserAgencyEntity checkAccount(String userName, String password);
}
