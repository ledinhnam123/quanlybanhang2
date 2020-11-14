package quanlybanhang.Rebository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.OrderDetailEntity;
@Repository
public interface OrderDetailRepository  extends JpaRepository< OrderDetailEntity, Integer>{

		List<OrderDetailEntity> findByOrderId(int orderId);
		
		//OrderDetailEntity findByIdOrder = fin
		
		
		
		
		
		
		
		
}
