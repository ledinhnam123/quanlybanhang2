package quanlybanhang.Rebository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {


	List<ProductEntity> findByCategoryId(int categoryid);
	//List<ProductEntity> findByNameAndCategoryId(String nameProduct, int categoryId);
	Optional<ProductEntity> findById(int id);
	List<ProductEntity> save(List<ProductDTO> productsDTO);
	
	List<ProductEntity> findByProductNameLike(String productName);
	
	@Query("Select product FROM ProductEntity product WHERE product.id=:id")
	List<ProductEntity> getByproductId(@Param("id")Integer id);
	
	//nhap
	@Query("Select product FROM ProductEntity product WHERE product.id= ?1")
	ProductEntity getByproducttId(Integer id);
	
	
	@Query(value="Select pro FROM ProductEntity pro WHERE pro.categoryId=:category_id",nativeQuery = true)
	List<ProductEntity> getByCategoryId(@Param("category_id") Integer category_id);
	
	//tim sản phẩm theo ten va category_id
	

	
	
}
