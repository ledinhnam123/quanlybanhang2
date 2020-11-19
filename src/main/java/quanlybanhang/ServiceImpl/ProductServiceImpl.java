package quanlybanhang.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DAO.ProductDAO;
import quanlybanhang.DAO.ProductDAOTest;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Request.AccountRequest;
import quanlybanhang.Request.FinProductUserAgencyRequest;
import quanlybanhang.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
 
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ProductDAOTest productDao;
	@Autowired
	private UserAgencyServiceImpl userAgencyImpl;


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

	@Override
	public List<ProductDTO> LaySanPhamTheoTen(String productName) {
		
		return productDAO.getProductLikeName("%"+productName+"%");
	}

	@Override
	public ProductDTO getByproducttId(Integer id) {
		
		return productDAO.getByproducttId(id);
	}

	

	@Override
	public JSONObject getAllProduct() {
		JSONObject js = new JSONObject();
		try {
			js.put("ListProduct:", productDao.getAllProduct());
		} catch (Exception e) {
			js.put("Error", "Có lỗi ở Service");
		}
		return js;
	}

	@Override
	public JSONObject findProductById(int id) {
		JSONObject js = new JSONObject();
		js.put("Product", productDao.findProductById(id));
		return js;
	}

	@Override
	public JSONObject findAllProductS1(AccountRequest request) {
		JSONObject js = new JSONObject();
		try {
			if(userAgencyImpl.checkAccount(request.getUserName(), request.getPass()) != null) {
				js.put("Product", productDao.findAllProductS1());
			}
			else {
				js.put("S1", "Khoong ton tai");
			}
			
		} catch (Exception e) {
			js.put("Errror", "ProductNull");
		}
		return js;
	}

	@Override
	public JSONObject getProuctByUserAgencyId(FinProductUserAgencyRequest request) {
		JSONObject js = new JSONObject();
		try {
			
			UserAgencyEntity check = userAgencyImpl.checkAccount(request.getAcount().getUserName(), request.getAcount().getPass());
			if(check!=null) {
				js.put("ProductOfUserAgency", productDAO.getProuctByUserAgencyId(request.getId()));
			}
			else {
				js.put("UserAgencyEntity", "Tai khoan ko dung");
			}

		} catch (Exception e) {
			js.put("Error", "Lỗi ở SeriveImpl");
		}
		return js;
	}

	@Override
	public JSONObject getProductByIdUser(int userId) {
		JSONObject js = new JSONObject();
		try {
			js.put("Product",productDAO.getProductByIdUser(userId));
		} catch (Exception e) {
			js.put("Error","Lỗi ở Service");
		}
		return js;
	}

	@Override
	public JSONObject searchProductByKeySearch(int id, String keysearch) {
		JSONObject data = new  JSONObject();
		try {
			data.put("searchProductByKeySearch", productDAO.searchProductByKeySearch(id, keysearch));
		} catch (Exception e) {
			data.put("Error","Lỗi ở Service");
		}
		return data;
	}


}
