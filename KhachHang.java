package QLsieuthimini;

import java.util.Scanner;

public class KhachHang implements INhap,IXuat{
	private int makh;
	private int sotuoi;
	private long sdtkh;
	private String tenkh;
	private String diachikh;
	private String phai;
	public KhachHang() {
		
	}
	public KhachHang(int makh, int sotuoi, long sdtkh, String tenkh, String diachikh, String phai) {
		this.makh = makh;
		this.sotuoi = sotuoi;
		this.sdtkh = sdtkh;
		this.tenkh = tenkh;
		this.diachikh = diachikh;
		this.phai = phai;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public int getSotuoi() {
		return sotuoi;
	}
	public void setSotuoi(int sotuoi) {
		this.sotuoi = sotuoi;
	}
	public long getSdtkh() {
		return sdtkh;
	}
	public void setSdtkh(long sdtkh) {
		this.sdtkh = sdtkh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDiachikh() {
		return diachikh;
	}
	public void setDiachikh(String diachikh) {
		this.diachikh = diachikh;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã số khách hàng: ");
		makh = in.nextInt();
		System.out.println("Nhập số điện thoại khách hàng: ");
		sdtkh = in.nextLong();
		System.out.println("Nhập số tuổi khách hàng: ");
		sotuoi = in.nextInt();
		in.nextLine();
		System.out.println("Nhập Họ và tên khách hàng: ");
		tenkh = in.nextLine();
		System.out.println("Nhập giới tính khách hàng: ");
		phai = in.nextLine();
		System.out.println("Nhập địa chỉ khách hàng: ");
		diachikh = in.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("Mã số khách hàng: " + makh);
		System.out.println("Họ và tên khách hàng: " + tenkh);
		System.out.println("Giới tính khách hàng: " + phai);
		System.out.println("Số tuổi: " + sotuoi);
		System.out.println("Số điện thoại nhân viên: " +sdtkh);
		System.out.println("Địa chỉ nhân viên: " + diachikh);		
	}
	@Override
	public String toString() {
		return "Mã số khách hàng: " + makh +
	            "\nHọ và tên khách hàng: " + tenkh +
	            "\nGiới tính khách hàng: " + phai +
	            "\nSố tuổi: " + sotuoi +
	            "\nSố điện thoại nhân viên: " + sdtkh +
	            "\nĐịa chỉ nhân viên: " + diachikh;
	}
	
}
