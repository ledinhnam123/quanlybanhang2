package quanlybanhang.Rebository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.OrderDetailEntity;

public interface OrderDetailRepository  extends JpaRepository< OrderDetailEntity, Integer>{

		List<OrderDetailEntity> findByOrderId(int orderId);
		
		
		
		
		
		
}
