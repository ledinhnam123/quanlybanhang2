package quanlybanhang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Request.OrderS1ManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;
@Service
public interface UserAgencyService {
	
	public UserAgencyEntity checkAccount(String userName, String password);
	
	public JSONObject AddOrderS1(OrderS1ManyProductRequest request);
	public boolean createOrderS1(int orders1Id, List<ProductOrderRequest> request);
}
