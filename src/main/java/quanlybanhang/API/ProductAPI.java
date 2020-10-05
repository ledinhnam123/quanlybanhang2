package quanlybanhang.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("Product")
public class ProductAPI {
	
	@Autowired
	private  ProductServiceImpl productServiceImpl;

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

}
