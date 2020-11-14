package quanlybanhang.Rebository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.UserEntity;
@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findById(int id);
	
	@Query(value= "select u.* from " + 
			 "user u " + 
			 "left join user_order ord on ord.user_id = u.id" + 
			 "where ord.id =: orderId " + 
			 "limit 1"
			, nativeQuery = true)
	public  UserEntity  finUserByOrderId(@Param(value ="orderId") int orderId);
	
	
	@Query(value = "select u.* from user u " + 
			"left join user_order uo  on u.id = uo.user_id " + 
			"where uo.id =:orderId", nativeQuery = true)
	public UserEntity finUserByIdOrder(@Param("orderId") int orderId);
}
