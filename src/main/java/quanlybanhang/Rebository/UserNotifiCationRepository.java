package quanlybanhang.Rebository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.UserNotifiCationEntity;

@Repository
public interface UserNotifiCationRepository extends JpaRepository<UserNotifiCationEntity, Integer>{
	
	@Query(value="select unf.*from user_notification unf where  user_id =:userId ",nativeQuery = true)
	public List<UserNotifiCationEntity> findNotifyByUserId(@Param("userId") int userId);
	
	Optional<UserNotifiCationEntity> findById(int id);
	
}
