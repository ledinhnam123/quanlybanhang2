package quanlybanhang.Rebository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {


	List<ProductEntity> findByCategoryId(int categoryid);
	//List<ProductEntity> findByNameAndCategoryId(String nameProduct, int categoryId);
	Optional<ProductEntity> findById(int id);
	
}
