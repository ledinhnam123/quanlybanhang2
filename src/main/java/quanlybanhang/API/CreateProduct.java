package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DAO.AdminDAO;
import quanlybanhang.Request.AccountRequest;
import quanlybanhang.Request.CreateProductRequest;
import quanlybanhang.Service.CreateProductService;

@RestController
@RequestMapping("api_create_product")
public class CreateProduct {
 @Autowired
 private CreateProductService createProductService;
 @Autowired
 private AdminDAO adminDao;

 
 
 @PostMapping("/admin")
 public ResponseEntity<?> createListProduct(@RequestBody CreateProductRequest request) {

	return ResponseEntity.ok(createProductService.adminCreateListProduct(request));
 }
 //test
 @GetMapping("/test")
 public ResponseEntity<?> check(@RequestBody AccountRequest request) {

		return ResponseEntity.ok(adminDao.checkAccount(request.getUserName(),request.getPass()));
	 }
 
 
 @PostMapping("/userAgency")
 public ResponseEntity<?> createListProducts(@RequestBody CreateProductRequest request) {

	return ResponseEntity.ok(createProductService.userAgencyCreateListProduct(request));
 }
 
 
 
}
