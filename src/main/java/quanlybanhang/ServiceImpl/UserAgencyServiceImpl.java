package quanlybanhang.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
import quanlybanhang.DAO.UserAgencyDAO;
import quanlybanhang.Entity.OrderS1Entity;
import quanlybanhang.Entity.ProductDetailEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Rebository.ProductDetailRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Rebository.UserAgencyRepository;
import quanlybanhang.Request.OrderS1ManyProductRequest;
import quanlybanhang.Request.ProductOrderRequest;
import quanlybanhang.Service.UserAgencyService;

@Service
public class UserAgencyServiceImpl implements UserAgencyService {

	@Autowired
	private UserAgencyDAO userADAO;


	@Autowired
	private ProductDetailRepository productDetailRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private UserAgencyRepository userAgencyRepo;

	@Override
	public UserAgencyEntity checkAccount(String userName, String password) {

		return userADAO.checkAccount(userName, password);
	}

	@Override
	public JSONObject AddOrderS1(OrderS1ManyProductRequest request) {

		JSONObject js = new JSONObject();
		try {
			OrderS1Entity orderS1 = userADAO.saveOrder(request.getUserAgencyId());
			UserAgencyEntity userEgency = userAgencyRepo.findOne(request.getUserAgencyId());
			
			if (orderS1 != null) {

				List<ProductOrderRequest> listProductOrder = request.getListProduct();
				List<ProductEntity> listProductNew =  new ArrayList<ProductEntity>();
				List<ProductDetailEntity> listProductDetail = new ArrayList<ProductDetailEntity>();
				boolean check = userADAO.createOrderS1(request.getUserAgencyId(), request.getListProduct());
				if (check == true) {
					for (ProductOrderRequest orderProduct : listProductOrder) {
						ProductEntity productf = new ProductEntity();
						ProductDetailEntity productDetailf = new ProductDetailEntity();
						ProductEntity product = productRepo.findOne(orderProduct.getProductId());
						
						if(product ==null) {
							
						}else {
							productf.setQuanty(orderProduct.getQty());
							
							//setProductDetail
							productDetailf.setCreateManId(request.getUserAgencyId());
							productDetailf.setProductId(productf.getId());
							productDetailf.setType(1);
							
							
						}
						//addLisst
						product = productRepo.saveAndFlush(product);
						productDetailf = productDetailRepo.saveAndFlush(productDetailf);
						listProductNew.add(productf);
						listProductDetail.add(productDetailf);
						

					}

				}
				js.put("ProductOrder",listProductNew);
				js.put("ProductDetail", listProductDetail);
			}
			
			

		} 
		catch (Exception e) {

			js.put("Error", "Loi xau ra owr service");
		}

		return js;

	}

	@Override
	public boolean createOrderS1(int orders1Id, List<ProductOrderRequest> request) {

		return userADAO.createOrderS1(orders1Id, request);
	}
	@Transactional
	public JSONObject addOrderNew(OrderS1ManyProductRequest request) {
		JSONObject js = new JSONObject();
try {
			
			OrderS1Entity orders1 = userADAO.saveOrder(request.getUserAgencyId());
			if(orders1 !=null) {
				
				js.put("OrderS1", userADAO.createOrderS1(orders1.getId(),request.getListProduct()));
				return js;
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	
	}
}
