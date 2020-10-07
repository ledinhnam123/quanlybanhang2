package quanlybanhang.Rebository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
	List<OrderEntity > findByUserId(int userId);
	
	
	List<OrderEntity > findById(int id);
	Optional<OrderEntity> findByIdAndUserId(int id, int userId);
	  
//	Optional<OrderEntity> findOrderId(int userId);
}
