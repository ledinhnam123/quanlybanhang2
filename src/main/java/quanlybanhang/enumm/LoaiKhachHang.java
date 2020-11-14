package quanlybanhang.enumm;

public enum LoaiKhachHang {

	KIMCUONG(3), VANG(2),
	BAC(1),NGUOIDUNG(0);

	private int code;


	LoaiKhachHang(int code){
	        this.code=code;
		}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

	

}
