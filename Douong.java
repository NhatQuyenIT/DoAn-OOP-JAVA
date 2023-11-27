package QLsieuthimini;

import java.util.Scanner;

public class Douong extends SanPham implements INhap,IXuat{
	private String ngaysx;
	private String hansudung;
	public Douong() {
		super();
	}
	
	public Douong(int masp, int soluongnhaphang, double tiennhaphang, double giasp, String tensp, String loaisp,
			NhaCungCap nhaCungCap, String ngaysx, String hansudung) {
		super(masp, soluongnhaphang, tiennhaphang, giasp, tensp, loaisp, nhaCungCap);
		this.ngaysx = ngaysx;
		this.hansudung = hansudung;
	}

	public String getNgaysx() {
		return ngaysx;
	}
	public void setNgaysx(String ngaysx) {
		this.ngaysx = ngaysx;
	}
	public String getHansudung() {
		return hansudung;
	}
	public void setHansudung(String hansudung) {
		this.hansudung = hansudung;
	}
	
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập ngày sản xuất: ");
		ngaysx = in.nextLine();
		System.out.println("Nhập hạn sử dụng: ");
		hansudung = in.nextLine();
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Ngày sản xuất: " + ngaysx);
		System.out.println("Hạn sử dụng: " + hansudung);
		
		double tongGiaTri = getGiasp() + tinhVAT();
	    double chitra = tongGiaTri + getTiennhaphang();
		System.out.println("Tổng giá trị sản phẩm: " + chitra);
	}
	 public double tinhVAT() {
			 return 0.1*getGiasp();
	 }
}