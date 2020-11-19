package quanlybanhang.Service;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.Request.CreateProductRequest;

@Service
public interface CreateProductService {

	
	public JSONObject adminCreateListProduct(CreateProductRequest request);
	public JSONObject userAgencyCreateListProduct(CreateProductRequest request);
}
