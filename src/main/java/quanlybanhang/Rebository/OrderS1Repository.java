package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.OrderS1Entity;

@Repository
public interface OrderS1Repository  extends JpaRepository<OrderS1Entity, Integer>{
 
}
