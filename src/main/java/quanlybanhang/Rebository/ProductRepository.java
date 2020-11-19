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

	// List<ProductEntity> findByNameAndCategoryId(String nameProduct, int
	// categoryId);
	Optional<ProductEntity> findById(int id);

	List<ProductEntity> save(List<ProductDTO> productsDTO);

	List<ProductEntity> findByProductNameLike(String productName);

	@Query("Select product FROM ProductEntity product WHERE product.id=:id")
	List<ProductEntity> getByproductId(@Param("id") Integer id);

	// nhap
	@Query("Select product FROM ProductEntity product WHERE product.id= ?1")
	ProductEntity getByproducttId(Integer id);

	@Query(value = "Select pro FROM ProductEntity pro WHERE pro.categoryId=:category_id", nativeQuery = true)
	List<ProductEntity> getByCategoryId(@Param("category_id") Integer category_id);

	// tim sản phẩm theo ten va category_id

	@Query(value = " Select pro.* from product pro " + " left join product_detail prd on prd.product_id = pro.id "
			+ " left join user_agency ua on ua.id = prd.create_man_id " + " where ua.id =:id ", nativeQuery = true)
	public List<ProductEntity> findProductByUserAgencyId(@Param("id") int id);

	//sử dung cau nay de lay sản phẩm 	
	@Query(value = " select pro.*  from product pro " + " left join product_detail prd on prd.product_id = pro.id "
			+ " left join user_agency_detail uad on uad.user_agency_id = prd.create_man_id "
			+ " left join user us on us.id = uad.user_id " + " where us.id =:userId " + " union "
			+ " select pro.*   from product pro " + " left join product_detail prd on prd.product_id = pro.id "
			+ " where type = 0 ", nativeQuery = true)
	public List<ProductEntity> findfProductByUserIdAndType(@Param("userId") int userId);
	
	@Query(value=" select pro.* from product pro " + 
			" left join category cate on cate.id = pro.category_id " + 
			" left join product_detail prd on prd.product_id = pro.id " + 
			" left join user_agency ua on ua.id = prd.create_man_id " + 
			" where  pro.quanty > 0 AND ua.id =:id AND cate.category_name LIKE %:keysearch% "+
			" order by pro.price desc " + 
			" limit 10 ",nativeQuery = true)
	public List<ProductEntity> searchProductByUserAgency(@Param("id") int id, @Param("keysearch") String keysearch);
	
}
