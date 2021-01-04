package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.OrderS1ProductEntity;

@Repository
public interface OrderS1ProductRepository extends JpaRepository<OrderS1ProductEntity, Integer> {

	
}
