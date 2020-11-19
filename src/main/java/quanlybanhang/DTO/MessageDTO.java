package quanlybanhang.DTO;

import quanlybanhang.Entity.MessageEntity;

public class MessageDTO {

	private int id;
	private String message;
	private int notifiId;
	
	public MessageDTO() {
		
	}
	public MessageDTO(MessageEntity messEntity) {
		this.id = messEntity.getId();
		this.message = messEntity.getMessage();
		this.notifiId = messEntity.getNotifiId();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNotifiId() {
		return notifiId;
	}
	public void setNotifiId(int notifiId) {
		this.notifiId = notifiId;
	}
	
	
	
	
}
