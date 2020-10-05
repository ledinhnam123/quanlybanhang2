package quanlybanhang.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quanlybanhang.DTO.OderDTO;
import quanlybanhang.Entity.OderEntity;
import quanlybanhang.Rebository.OderRepository;

@Component
public class OderDAO {

	@Autowired
	private OderRepository oderRepository;

	ProductDAO productDao = new ProductDAO();
	// b1.lôi cái sản phẩm theo id ra

	public OderEntity save(OderDTO oderDTO) {

		OderEntity oderEntity = OderDTO.mapperToEntity(oderDTO);

		return oderRepository.saveAndFlush(oderEntity);
	}

	public OderEntity addnewOder(int idUser, OderDTO oderDTO) {

		OderEntity ode = new OderEntity();
		ode.setUserId(idUser);
		
		OderEntity oderEntity = OderDTO.mapperToEntity(oderDTO);

		return oderRepository.saveAndFlush(oderEntity);
	}
	
}
