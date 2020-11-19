package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.UserAgencyEntity;

@Repository
public interface UserAgencyRepository extends JpaRepository<UserAgencyEntity, Integer>{

	
	@Query(value ="select ua.* from user_agency ua " + 
			" where ua.user_name=:userName AND ua.password =:password ", nativeQuery = true)
	public UserAgencyEntity finUserAgencyByNameAndPassword(@Param("userName") String userName,@Param("password") String password);
	
	
	
	
}
