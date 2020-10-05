package quanlybanhang.Rebository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	Optional<CategoryEntity> findById(int id);
	
}
