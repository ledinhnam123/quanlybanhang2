package quanlybanhang.Rebository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	Optional<CategoryEntity> findById(int id);
	
}
