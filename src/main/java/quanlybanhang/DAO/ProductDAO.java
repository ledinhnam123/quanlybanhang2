package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.CategoryEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.CategoryRepository;
import quanlybanhang.Rebository.ProductRepository;

@Component
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository cateRepository;
	
	//xuất toàn bộ
	
	public List<ProductDTO> finAllProduct(){
		List<ProductEntity> pros = productRepository.findAll();
		List<ProductDTO> proRes = new ArrayList<ProductDTO>();
		for(ProductEntity pro : pros) {
			ProductDTO dto = ProductDTO.mapperToDTO(pro);
			proRes.add(dto);
		}
		return proRes;
	}
 //thêm  
	public ProductEntity save (ProductDTO productDTO) {
		ProductEntity pro = ProductDTO.mapperToEntity(productDTO);
		return productRepository.saveAndFlush(pro);
	}
	public ProductEntity finOne(int id) {
		ProductEntity p = productRepository.findOne(id);
		return p;
	}
	public ProductDTO findOne(int id) {
		
		ProductEntity pro = productRepository.findOne(id);
		ProductDTO dto = ProductDTO.mapperToDTO(pro);
		return dto;
	}

	//xóa
	public void deleteProductById(int id) {
		productRepository.delete(id);
		
	}
	//trả về 1 danh sách có tên sản phẩm 
	public List<ProductDTO> findByCategory(int categoryid) {
		List<ProductEntity> pros = productRepository.findByCategoryId(categoryid);
		List<ProductDTO> proRes = new ArrayList<ProductDTO>();
		for(ProductEntity pro : pros) {
			ProductDTO dto = ProductDTO.mapperToDTO(pro);
			
			CategoryEntity cate = cateRepository.findOne(pro.getCategoryId());
			if(cate != null) {
				dto.setCategoryName(cate.getCategoryName());
				
			}
			proRes.add(dto);
			
			
		}
		return proRes;
	}	
	

}
