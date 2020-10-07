package quanlybanhang.DTO;

import org.modelmapper.ModelMapper;

import quanlybanhang.Entity.UserEntity;

public class UserDTO {

	
	private int id;
	private String nameUser;
	
	public UserDTO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public static UserDTO mapperToDTO(UserEntity userEntity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userEntity, UserDTO.class);
	}
	
	//DL từ client truyền xuống
	public static UserEntity mapperToEntity(UserDTO userDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userDTO,UserEntity.class);
	}
	
}
