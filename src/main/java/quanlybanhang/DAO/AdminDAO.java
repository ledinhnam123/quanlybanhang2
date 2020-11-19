package quanlybanhang.DAO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.AdminEntity;
import quanlybanhang.Rebository.AdminRepository;
@Transactional
@Component
public class AdminDAO {

	@Autowired
	private AdminRepository adminRepo;
	
	public AdminEntity checkAccount(String userName, String password) {
		AdminEntity admin = adminRepo.finAdminByNameAndPassword(userName, password);
		if(admin!=null) {
			return admin;
		}
		else {
			return null;
		}
		
		
	}
	
}
