package quanlybanhang.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DAO.CreateProductDAO;
import quanlybanhang.Entity.AdminEntity;
import quanlybanhang.Entity.ProductDetailEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Rebository.AdminRepository;
import quanlybanhang.Rebository.ProductDetailRepository;
import quanlybanhang.Rebository.UserAgencyRepository;
import quanlybanhang.Request.CreateProductRequest;
import quanlybanhang.Service.CreateProductService;

@Service
public class CreateProductServiceImpl implements CreateProductService {

	@Autowired
	private CreateProductDAO createProductDAO;
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private UserAgencyServiceImpl userAgencyImpl;
	@Autowired
	private UserAgencyRepository userAgencyRepo;
	@Autowired
	private ProductDetailRepository productDetailRepo;
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public JSONObject adminCreateListProduct(CreateProductRequest request) {
		JSONObject js = new JSONObject();
		try {
			List<ProductDetailEntity> productDeTail = new ArrayList<ProductDetailEntity>();
			AdminEntity admin = adminRepo.findOne(request.getId());

			if (admin != null) {
				
				List<ProductEntity> proRes = createProductDAO.adminCreateProduct(request.getListProduct());
				if (adminServiceImpl.checkAccount(request.getAccount().getUserName(),
						request.getAccount().getPass()) != null) {
					js.put("adminCreateListProduct", proRes);
					
					for(ProductEntity productList : proRes ) {
						ProductDetailEntity productDt = new ProductDetailEntity();
						productDt.setCreateManId(request.getId());
						productDt.setProductId(productList.getId());
						productDt.setType(0);
						productDt = productDetailRepo.saveAndFlush(productDt);
						productDeTail.add(productDt);
					}
				} else {
					js.put("Amind", "Admin khong ton tai");
				}
				
			} else {
				js.put("Error", "Id không tồn tại");
			}

		} catch (Exception e) {
			js.put("Error", "Loi o ServieceIpml");
		}

		return js;
	}

	@Override
	public JSONObject userAgencyCreateListProduct(CreateProductRequest request) {
		JSONObject js = new JSONObject();
		try {

			List<ProductDetailEntity> productDeTail = new ArrayList<ProductDetailEntity>();
			UserAgencyEntity userAgen = userAgencyRepo.findOne(request.getId());

			if (userAgen != null) {

				List<ProductEntity> proRes = createProductDAO.UserAgencyCreateProduct(request.getListProduct());
				
				if (userAgencyImpl.checkAccount(request.getAccount().getUserName(),
						request.getAccount().getPass()) != null) {
					js.put("UserAgency", proRes);

					for (ProductEntity listProduct : proRes) {
						ProductDetailEntity productDt = new ProductDetailEntity();
						productDt.setCreateManId(request.getId());
						productDt.setType(1);
						productDt.setProductId(listProduct.getId());
						productDt = productDetailRepo.saveAndFlush(productDt);
						productDeTail.add(productDt);
					}
					return js;
					
				} else {
					js.put("UserAgency", "Tai khoan khong ton tai");
				}

			} else {
				js.put("userAgen", "không tồn tại Id");
			}
		} catch (Exception e) {
			js.put("Error", "Loi o serviceIpml");
		}
		return js;
	}
}
