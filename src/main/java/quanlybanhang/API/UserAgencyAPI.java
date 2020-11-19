package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.Request.AccountRequest;
import quanlybanhang.Service.ProductService;

@RestController
@RequestMapping("user_agency")
public class UserAgencyAPI {

@Autowired
private ProductService productService;
	@GetMapping("product/S1")
	 public ResponseEntity<?> GetAllProductS1(@RequestBody AccountRequest request) {

			return ResponseEntity.ok(productService.findAllProductS1(request));
		 }
}
