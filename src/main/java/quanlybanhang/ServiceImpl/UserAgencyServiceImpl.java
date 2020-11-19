package quanlybanhang.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.UserAgencyDAO;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Service.UserAgencyService;

@Service
public class UserAgencyServiceImpl implements UserAgencyService {

	@Autowired
	private UserAgencyDAO userADAO;
	@Override
	public UserAgencyEntity checkAccount(String userName, String password) {
		
		return userADAO.checkAccount(userName, password);
	}

}
