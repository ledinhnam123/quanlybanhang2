package quanlybanhang.Rebository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

	Optional<CartEntity> findByProductId(int productId);
	
}
