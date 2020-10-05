package quanlybanhang.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quanlybanhang.DTO.OderDTO;
import quanlybanhang.Entity.OderEntity;
import quanlybanhang.ServiceImpl.OderServiceImpl;

@RestController
@RequestMapping("Oder")
public class OderAPI {

	
	@Autowired
	private OderServiceImpl oderServiceImpl;
	
	@PostMapping("/add_Oder")
	public OderEntity  addOder(@RequestBody OderDTO oderDTO) {
		return oderServiceImpl.save(oderDTO);
	}
	
	
	
}
