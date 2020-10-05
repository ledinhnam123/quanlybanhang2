package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;

@Service
public interface ProductService    {
	
	
	public List<ProductDTO> findAllProduct();
	public ProductEntity save(ProductDTO productDTO);
	public ProductEntity finOne(int id);
	public void deleteByID(int id);
	public List<ProductDTO> findByCategoryId(int categotyid);
	

}
