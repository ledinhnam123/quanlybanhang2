package quanlybanhang.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.ProductDAO;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
 
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductDTO> findAllProduct() {
		
		return productDAO.finAllProduct();
	}

	@Override
	public ProductEntity save(ProductDTO productDTO) {
		return productDAO.save(productDTO);
	}

	@Override
	public ProductEntity finOne(int id) {
		
		return productDAO.finOne(id);
	}

	@Override
	public void deleteByID(int id) {
		
		productDAO.deleteProductById(id);
		
	}

	@Override
	public List<ProductDTO> findByCategoryId(int categoryid) {
		
		return productDAO.findByCategory(categoryid);
	}


	



	
	

	
	


	

}
