package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_s1")
public class OrderS1Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="user_agency_id")
	private int userAgencyId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserAgencyId() {
		return userAgencyId;
	}
	public void setUserAgencyId(int userAgencyId) {
		this.userAgencyId = userAgencyId;
	}
	
	
	

}
