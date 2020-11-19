package quanlybanhang.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Request.FinProductUserAgencyRequest;
import quanlybanhang.Service.ProductService;
import quanlybanhang.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("Product")
public class ProductAPI {
	
	@Autowired
	private  ProductServiceImpl productServiceImpl;
	@Autowired
	private ProductService productService;
	

	@RequestMapping("/get_all_product")
	public List<ProductDTO> getAll(){
		return (List<ProductDTO>) productServiceImpl.findAllProduct();
	}
	
	@PostMapping("/add_product")
	public ProductEntity  addProduct(@RequestBody ProductDTO productDTO) {
		
		return productServiceImpl.save(productDTO);
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable ("id") int id) {
			ProductEntity tam =productServiceImpl.finOne(id);
			if(tam==null) {
				System.out.println("Not Exist Id! Done delete" );
				return;
			}
			productServiceImpl.deleteByID(id);
			System.out.println("delete Product Id" + id );
	}
	@RequestMapping("/{id}")
	public ProductEntity findById(@PathVariable ("id") int id) {
		ProductEntity tam = productServiceImpl.finOne(id);
		if(tam==null) {
			System.out.println("Id" + tam  + "Not Found");
		}
		return tam;
	}
	@PutMapping("/update_product")
	public ProductEntity updateProduct(@RequestBody ProductDTO productDTO) {
		ProductEntity tam = productServiceImpl.finOne(productDTO.getId());
		if(tam!=null) {
			System.out.println("Update Product ID" + productDTO.getId());
			productServiceImpl.save(productDTO);
			return tam;
			
		}
		System.out.println("Not Found");
		return tam;
	}
	
	//Hiển thị sản phẩm theo category
	@RequestMapping("/categoryid/{categoryid}")
	public List<ProductDTO> getProductCategoryID(@PathVariable("categoryid") int categoryid){
		return (List<ProductDTO>)productServiceImpl.findByCategoryId(categoryid);
	}
	
	//List Sản phẩm có tên theo Like:Done
	
	@GetMapping("/like_name/{productName}")
	public List<ProductDTO> getProductLikeName(@PathVariable("productName") String productName){
		return (List<ProductDTO>) productServiceImpl.LaySanPhamTheoTen(productName);
	}
	//lấy sản phẩm theo id(@Query) ->done
	@GetMapping("/get_name/{id}")
	public ProductDTO getProductNameQ(@PathVariable("id") int id) {
		
		return productServiceImpl.getByproducttId(id);
	}
	@GetMapping("api/getAllProduct")
	public JSONObject getAllProduct() {
		return productServiceImpl.getAllProduct();
	}
	@GetMapping("api/getProductById")
	public JSONObject getProductById(@RequestParam("productId") int productId) {
		return productService.findProductById(productId);
	}
	
	///Product By UserAgencyId
	@GetMapping("/user_Agency_product")
	public ResponseEntity<?> getProductofUserAgency(@RequestBody FinProductUserAgencyRequest request) {
		return ResponseEntity.ok(productService.getProuctByUserAgencyId(request));
	}
	
	//GetProductBy UserId
	
	@GetMapping("/userId_product")
	public ResponseEntity<?> getProductByUserId(@RequestParam("userId") int userId){
		return ResponseEntity.ok(productService.getProductByIdUser(userId));
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchProductByCategory(@RequestParam("id") int id, @RequestParam("keysearch") String keysearch){
		return  ResponseEntity.ok(productService.searchProductByKeySearch(id, keysearch));
	}
	
	

	
}
