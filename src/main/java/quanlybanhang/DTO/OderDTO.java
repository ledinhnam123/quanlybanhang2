package quanlybanhang.DTO;

import org.modelmapper.ModelMapper;

import quanlybanhang.Entity.OderEntity;

public class OderDTO {

	private int id;
	private String productName;
	private String nameUser;
	private double quantily;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public double getQuantily() {
		return quantily;
	}

	public void setQuantily(double quantily) {
		this.quantily = quantily;
	}

	public static OderDTO mapperToDTO(OderEntity oderEntity) {

		ModelMapper mapper = new ModelMapper();
		return mapper.map(oderEntity, OderDTO.class);
	}

	public static OderEntity mapperToEntity(OderDTO oderDTO) {

		ModelMapper mapper = new ModelMapper();
		return mapper.map(oderDTO, OderEntity.class);
	}

}
