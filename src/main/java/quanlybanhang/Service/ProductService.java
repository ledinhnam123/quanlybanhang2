package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Request.AccountRequest;
import quanlybanhang.Request.FinProductUserAgencyRequest;

@Service
public interface ProductService    {
	
	
	public List<ProductDTO> findAllProduct();
	public ProductEntity save(ProductDTO productDTO);
	public ProductEntity finOne(int id);
	public void deleteByID(int id);
	public List<ProductDTO> findByCategoryId(int categotyid);
	public List<ProductDTO> LaySanPhamTheoTen(String productName);
	public ProductDTO getByproducttId(Integer id);
	
	public JSONObject getAllProduct();
	public JSONObject findProductById(int id);
	public JSONObject findAllProductS1(AccountRequest request);
	public JSONObject getProuctByUserAgencyId(FinProductUserAgencyRequest request);
	
	public JSONObject getProductByIdUser(int userId);
	public JSONObject searchProductByKeySearch(int id, String keysearch);

	

}
