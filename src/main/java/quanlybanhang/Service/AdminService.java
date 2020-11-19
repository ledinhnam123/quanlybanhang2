package quanlybanhang.Service;

import org.springframework.stereotype.Service;

import quanlybanhang.Entity.AdminEntity;

@Service
public interface AdminService {

	public AdminEntity checkAccount(String userName, String password);
}
