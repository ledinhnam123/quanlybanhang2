package quanlybanhang.Service;

import org.springframework.stereotype.Service;

import quanlybanhang.DTO.OderDTO;
import quanlybanhang.Entity.OderEntity;

@Service
public interface OderService {

	public OderEntity save(OderDTO oderDTO);
		
}
