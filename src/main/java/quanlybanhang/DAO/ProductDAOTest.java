package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.DTO.Productdtotest;
import quanlybanhang.Entity.ProductDetailEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Rebository.ProductDetailRepository;
import quanlybanhang.Rebository.ProductRepository;

@Component
public class ProductDAOTest {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductDetailRepository productDetailRepo;

	// get List Sản phẩm
	public List<Productdtotest> getAllProduct() {
		try {

			List<Productdtotest> listProductDTO = new ArrayList<>();
			List<ProductEntity> listProduct = productRepo.findAll();

			for (ProductEntity product : listProduct) {

				Productdtotest productDTO = new Productdtotest(product);

				listProductDTO.add(productDTO);
			}
			return listProductDTO;

		} catch (Exception e) {

		}
		return new ArrayList<>();

	}

	public List<Productdtotest> findAllProductS1() {
		try {
			// s1 xem được toàn bộ sản phẩm của admin, type = 0, và sản phẩm của chính nó tạo ra

			List<Productdtotest> listProductDTO = new ArrayList<>();
			List<ProductEntity> listProduct = productRepo.findAll();

			for (ProductEntity product : listProduct) {
				
				Productdtotest productDTO = new Productdtotest(product);

				listProductDTO.add(productDTO);

			}
			return listProductDTO;

		} catch (Exception e) {

		}
		return new ArrayList<>();

	}

	public List<Productdtotest> findAllProductUser(int id) {
		try {
			// xuat ra toan bo san pham cos type 1

			List<Productdtotest> listProductDTO = new ArrayList<>();
			List<ProductEntity> listProduct = productRepo.findAll();
			
			List<ProductDetailEntity> productDetail = productDetailRepo.findAll();
			for(ProductDetailEntity listDetail: productDetail) {
				
			}
			
			
			for (ProductEntity product : listProduct) {
				
				Productdtotest productDTO = new Productdtotest(product);
				
				listProductDTO.add(productDTO);
				

			}
			return listProductDTO;

		} catch (Exception e) {

		}
		return new ArrayList<>();

	}

	public Productdtotest findProductById(int id) {
		try {

			ProductEntity product = productRepo.findOne(id);
			Productdtotest productDTO = new Productdtotest();
			if (product != null) {

				productDTO.setId(product.getId());
				productDTO.setProductName(product.getProductName());
				productDTO.setCategoryId(product.getCategoryId());
				productDTO.setPrice(product.getPrice());
				productDTO.setQuanty(product.getQuanty());
			}
			return productDTO;
		} catch (Exception e) {
			return null;
		}

	}
}
