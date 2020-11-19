package quanlybanhang.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.AdminDAO;
import quanlybanhang.Entity.AdminEntity;
import quanlybanhang.Service.AdminService;

@Service
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private AdminDAO adminDao;

	@Override
	public AdminEntity checkAccount(String userName, String password) {
		return adminDao.checkAccount(userName, password);
	}

}
