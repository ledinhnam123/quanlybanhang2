package quanlybanhang.Response;

import java.util.List;

public class NotificationResponse {


	private int totalNotifyNo;
	

	public int getTotalNotifyNo() {
		return totalNotifyNo;
	}



	public void setTotalNotifyNo(int totalNotifyNo) {
		this.totalNotifyNo = totalNotifyNo;
	}



	public List<NotifiCation> getListNotifiCation() {
		return listNotifiCation;
	}



	public void setListNotifiCation(List<NotifiCation> listNotifiCation) {
		this.listNotifiCation = listNotifiCation;
	}



	List<NotifiCation> listNotifiCation;
	
	
	
	public class NotifiCation{
		private int ProductName;
		private String message;
		public int getProductName() {
			return ProductName;
		}
		public void setProductName(int productName) {
			ProductName = productName;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}
	
}
