package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository< AdminEntity, Integer>{

	@Query(value ="select a.*from admin a " + 
			" where a.user_name=:userName AND a.password =:password ", nativeQuery = true)
	public AdminEntity finAdminByNameAndPassword(@Param("userName") String userName,@Param("password") String password);
	
	
	//checkUser.name
	@Query(value="select a.*from admin a " + 
			" where a.user_name=:userName " + 
			" LIMIT 1 " , nativeQuery = true)
	public AdminEntity findAdminByUserName(@Param("userName") String userName);
}
