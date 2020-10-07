package quanlybanhang.DTO;

import org.modelmapper.ModelMapper;

import quanlybanhang.Entity.OrderEntity;

public class OrderDTO {

	private int id;
	private int userId;
	

	public OrderDTO() {

	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	// DL móc tư csdl lên
	public static OrderDTO mapperToDTO(OrderEntity orderEntity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(orderEntity, OrderDTO.class);
	}

	// DL từ client truyền xuống
	public static OrderEntity mapperToEntity(OrderDTO ordertDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(ordertDTO, OrderEntity.class);
	}

}
