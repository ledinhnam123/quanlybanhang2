package quanlybanhang.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="oder_detail")
public class OderDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name ="oder_id")
	private int oderId;
	
	@Column(name="total")
	private double total;

	public OderDetail() {
		
	}
	
	public OderDetail(int id, int oderId, double total) {
		
		this.id = id;
		this.oderId = oderId;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
}
