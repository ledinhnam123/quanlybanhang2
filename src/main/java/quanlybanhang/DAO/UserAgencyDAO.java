package quanlybanhang.DAO;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.Entity.OrderS1Entity;
import quanlybanhang.Entity.OrderS1ProductEntity;
import quanlybanhang.Entity.ProductDetailEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Rebository.OrderS1ProductRepository;
import quanlybanhang.Rebository.OrderS1Repository;
import quanlybanhang.Rebository.ProductDetailRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Rebository.UserAgencyRepository;
import quanlybanhang.Request.ProductOrderRequest;

@Transactional
@Component
public class UserAgencyDAO {

	@Autowired
	private UserAgencyRepository userAgencyRepo;
	@Autowired
	private OrderS1Repository orderS1Repo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductDetailRepository productDetailRepo;
	@Autowired
	private OrderS1ProductRepository orderS1ProductRepo;

	Date date1 = new Date();

	public UserAgencyEntity checkAccount(String userName, String password) {

		UserAgencyEntity useragency = userAgencyRepo.finUserAgencyByNameAndPassword(userName, password);
		if (useragency != null) {
			return useragency;
		} else {
			return null;
		}
	}

//	public int createOrderS1(int order) 

	public OrderS1Entity saveOrder(int userAgencyId) {

		OrderS1Entity orders1 = new OrderS1Entity();
		UserAgencyEntity user = userAgencyRepo.findOne(userAgencyId);
		if (user != null) {
			orders1.setUserAgencyId(userAgencyId);
			orders1 = orderS1Repo.saveAndFlush(orders1);
			return orders1;
		} else {
			return null;
		}

	}
 @Transactional
	public boolean createOrderS1(int orders1Id, List<ProductOrderRequest> request) {
		try {
			double totalMoney = 0; // tong tien order
			
			for (ProductOrderRequest listOrder : request) {
				OrderS1ProductEntity orderS1 = new OrderS1ProductEntity();
				orderS1.setOrderS1Id(orders1Id);
				orderS1.setCreateDate(date1);
				orderS1.setProductId(listOrder.getProductId());
				ProductEntity product = productRepo.findOne(listOrder.getProductId());
				orderS1.setProductPrice(product.getPrice());
				orderS1.setProductQuanty(listOrder.getQty());
				double totalMoneyProduct = product.getPrice() * listOrder.getQty();
				orderS1.setTotalMoney(totalMoneyProduct);
				// save
				orderS1 = orderS1ProductRepo.saveAndFlush(orderS1);
				// set lại Product và productDetail
				
				
//				int quantyProducAmin=  product.getQuanty() - listOrder.getQty();
//				product.setQuanty(quantyProducAmin);
//				
//				product = productRepo.saveAndFlush(product);
				//int quantyProductS1 = product.getQuanty()+listOrder.getQty();
				totalMoney += totalMoneyProduct;

			}
			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
