package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.CategoryEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.CategoryRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Request.ProductRequest;

@Component
public class CreateProductDAO {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;
	
	/*
	 * public Users CheckAccount(Users user) { String pass = user.getPassword();
	 * user = userDao.GetUserByAcc(user); if(user != null) { if(BCrypt.checkpw(pass,
	 * user.getPassword())) { return user; } else { return null; }
	 * 
	 * } return null;
	 * 
	 * }
	 */

	public List<ProductEntity> adminCreateProduct(List<ProductRequest> request) {

		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		for (ProductRequest listProduct : request) {
			ProductEntity product = new ProductEntity();
			product.setProductName(listProduct.getProductName());
			product.setPrice(listProduct.getPrice());
			product.setQuanty(listProduct.getQuantity());

			CategoryEntity cate = categoryRepo.findOne(listProduct.getCategoryId());
			if (cate != null) {
				product.setCategoryId(listProduct.getCategoryId());
				product = productRepo.saveAndFlush(product);
			}
			productList.add(product);
		}

		return productList;

	}
	//findAllProduct
	
	
	
	//userAgency create Prodcuct
	public List<ProductEntity> UserAgencyCreateProduct(List<ProductRequest> request) {

		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		for (ProductRequest listProduct : request) {
			ProductEntity product = new ProductEntity();
			product.setProductName(listProduct.getProductName());
			product.setPrice(listProduct.getPrice());
			product.setQuanty(listProduct.getQuantity());
			CategoryEntity cate = categoryRepo.findOne(listProduct.getCategoryId());
			if (cate != null) {
				product.setCategoryId(listProduct.getCategoryId());
				product = productRepo.saveAndFlush(product);
			}
			
			productList.add(product);
		}

		return productList;

	}
	
	//
	
}
