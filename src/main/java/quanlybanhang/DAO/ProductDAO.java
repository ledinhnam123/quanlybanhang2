package quanlybanhang.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import javassist.bytecode.stackmap.TypeData.ClassName;
import quanlybanhang.DTO.ProductDTO;
import quanlybanhang.Entity.CategoryEntity;
import quanlybanhang.Entity.ProductEntity;
import quanlybanhang.Entity.UserAgencyEntity;
import quanlybanhang.Entity.UserEntity;
import quanlybanhang.Rebository.CategoryRepository;
import quanlybanhang.Rebository.ProductRepository;
import quanlybanhang.Rebository.UserAgencyRepository;
import quanlybanhang.Rebository.UserRepository;

@Component
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository cateRepository;
	@Autowired
	private UserAgencyRepository userAgencyRepo;

	@Autowired
	private UserRepository userRepo;

	// xuất toàn bộ

	public List<ProductDTO> finAllProduct() {
		List<ProductEntity> pros = productRepository.findAll();
		List<ProductDTO> proRes = new ArrayList<ProductDTO>();
		for (ProductEntity pro : pros) {
			ProductDTO dto = ProductDTO.mapperToDTO(pro);
			proRes.add(dto);
		}
		return proRes;
	}

	// thêm
	public ProductEntity save(ProductDTO productDTO) {
		ProductEntity pro = ProductDTO.mapperToEntity(productDTO);
		return productRepository.saveAndFlush(pro);
	}

	public ProductEntity finOne(int id) {
		ProductEntity p = productRepository.findOne(id);
		return p;
	}

	public ProductDTO findOne(int id) {

		ProductEntity pro = productRepository.findOne(id);
		ProductDTO dto = ProductDTO.mapperToDTO(pro);
		return dto;
	}

	// xóa
	public void deleteProductById(int id) {
		productRepository.delete(id);

	}

	// trả về 1 danh sách có tên sản phẩm
	public List<ProductDTO> findByCategory(int categoryid) {
		List<ProductEntity> pros = productRepository.findByCategoryId(categoryid);
		List<ProductDTO> proRes = new ArrayList<ProductDTO>();
		for (ProductEntity pro : pros) {
			ProductDTO dto = ProductDTO.mapperToDTO(pro);

			CategoryEntity cate = cateRepository.findOne(pro.getCategoryId());
			if (cate != null) {
				dto.setCategoryName(cate.getCategoryName());

			}
			proRes.add(dto);

		}
		return proRes;
	}

	// ProductLikeLikeName

	public List<ProductDTO> getProductLikeName(String productName) {
		List<ProductEntity> pross = productRepository.findByProductNameLike(productName);
		List<ProductDTO> proRes = new ArrayList<ProductDTO>();
		for (ProductEntity pro : pross) {
			ProductDTO dto = ProductDTO.mapperToDTO(pro);
			proRes.add(dto);
		}
		return proRes;
	}

	public ProductDTO getByproducttId(Integer id) {

		ProductEntity pro = productRepository.getByproducttId(id);
		ProductDTO dto = ProductDTO.mapperToDTO(pro);
		return dto;
	}

	// FindAllProductById Agency
	public List<ProductEntity> getProuctByUserAgencyId(int id) {
		UserAgencyEntity userAgencyEntity = userAgencyRepo.findOne(id);
		if (userAgencyEntity != null) {
			List<ProductEntity> product = productRepository.findProductByUserAgencyId(id);
			return product;
		} else {
			return null;
		}

	}

//find productBy User Id
	public List<ProductEntity> getProductByIdUser(int userId) {
		UserEntity user = userRepo.findOne(userId);
		if (user != null) {

			List<ProductEntity> product = productRepository.findfProductByUserIdAndType(userId);
			// product.stream().sorted().collect(Collectors.toList());
			// product.stream().sorted(Comparator.comparing(ProductEntity::getId));
			product = product.stream().sorted(Comparator.comparingInt(ProductEntity::getId))
					.collect(Collectors.toList());
			return product;
		} else {
			return null;
		}

	}

	public List<ProductEntity> searchProductByKeySearch(int id, String keysearch) {
		UserAgencyEntity userA = userAgencyRepo.findOne(id);
		if (userA != null) {
			List<ProductEntity> productEntities = productRepository.searchProductByUserAgency(id, keysearch);
			return productEntities;
		} else {
			return null;
		}

	}

}
