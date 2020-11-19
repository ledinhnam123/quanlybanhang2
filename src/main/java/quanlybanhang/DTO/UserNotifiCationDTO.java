package quanlybanhang.DTO;

import java.util.Date;

import quanlybanhang.Entity.UserNotifiCationEntity;

public class UserNotifiCationDTO {

	private int id;
	private int user_id;
	private int status ;
	private int type;
	private int code;
	private Date createdDate;
	private Date updatedDate;
	
	public UserNotifiCationDTO() {
		
	}
	public UserNotifiCationDTO(UserNotifiCationEntity userNotifiEntity) {
		this.id = userNotifiEntity.getId();
		this.user_id = userNotifiEntity.getUserId();
		this.status = userNotifiEntity.getStatusMessage();
		this.type = userNotifiEntity.getType();
		this.createdDate = userNotifiEntity.getCreateDate();
		this.updatedDate = userNotifiEntity.getUpdateDate();
		this.code = userNotifiEntity.getCode();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
