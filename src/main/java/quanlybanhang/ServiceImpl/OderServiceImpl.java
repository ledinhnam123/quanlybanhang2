package quanlybanhang.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.DAO.OderDAO;
import quanlybanhang.DTO.OderDTO;
import quanlybanhang.Entity.OderEntity;
import quanlybanhang.Service.OderService;


@Service
public class OderServiceImpl implements OderService {

	
	@Autowired
	private OderDAO oderDao;
	@Override
	public OderEntity save(OderDTO oderDTO) {
	
		return oderDao.save(oderDTO);
	}

	
}
