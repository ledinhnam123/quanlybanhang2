package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.UserAgencyDetailEntity;

@Repository
public interface UserAgencyDetailRepository extends JpaRepository<UserAgencyDetailEntity, Integer> {

	
}
