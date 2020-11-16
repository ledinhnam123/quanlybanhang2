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

	private List<ListNotifyResponse> listNotify;

	public List<ListNotifyResponse> getListNotify() {
		return listNotify;
	}

	public void setListNotify(List<ListNotifyResponse> listNotify) {
		this.listNotify = listNotify;
	}
	
	 

	

	
}
