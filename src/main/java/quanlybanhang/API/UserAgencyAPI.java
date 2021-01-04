package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.Request.AccountRequest;
import quanlybanhang.Request.OrderS1ManyProductRequest;
import quanlybanhang.Service.ProductService;
import quanlybanhang.Service.UserAgencyService;

@RestController
@RequestMapping("user_agency")
public class UserAgencyAPI {

@Autowired
private ProductService productService;
@Autowired
private UserAgencyService userAgencyService;

	@GetMapping("product/S1")
	 public ResponseEntity<?> GetAllProductS1(@RequestBody AccountRequest request) {

			return ResponseEntity.ok(productService.findAllProductS1(request));
		 }
	

	@PostMapping("addOrderS1")
	public ResponseEntity<?> createOrderS1(@RequestBody OrderS1ManyProductRequest request){
		return ResponseEntity.ok(userAgencyService.AddOrderS1(request));
	}
}
