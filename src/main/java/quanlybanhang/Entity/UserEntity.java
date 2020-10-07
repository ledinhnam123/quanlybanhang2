package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id")
	private  int id;
	
	@Column(name="user_name")
	private String nameUser;

	public UserEntity() {
		
	}
	
	public UserEntity(int id, String nameUser) {
		this.id = id;
		this.nameUser = nameUser;
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
	

}
