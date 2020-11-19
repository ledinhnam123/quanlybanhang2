package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.ProductDetailEntity;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity , Integer> {

	
}
