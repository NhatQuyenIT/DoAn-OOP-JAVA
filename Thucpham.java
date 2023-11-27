package QLsieuthimini;

import java.util.Scanner;

// loại gồm có: thịt, rau, củ ,quả
public class Thucpham extends SanPham implements INhap,IXuat{
	private double tienVAT;
	
	public Thucpham() {
		super();
	}
	
	public Thucpham(int masp, int soluongnhaphang, double tiennhaphang, double giasp, String tensp, String loaisp,
			NhaCungCap nhaCungCap, double tienVAT) {
		super(masp, soluongnhaphang, tiennhaphang, giasp, tensp, loaisp, nhaCungCap);
		this.tienVAT = tienVAT;
	}

	public double getTiendichvu() {
		return tienVAT;
	}
	public void setTiendichvu(double tiendichvu, double tienVAT) {
		this.tienVAT = tienVAT;
	}
	
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập số tiền cần chi trả cho dịch vụ đông lạnh: ");
		tienVAT = in.nextDouble();
	}
	@Override
	public void xuat() {
		super.xuat();
		// Tổng giá trị sản phẩm kèm VAT
	    double tongGiaTri = getGiasp() + tinhVAT();
	    double chitra = tongGiaTri + getTiennhaphang();
	    System.out.println("Tổng giá trị sản phẩm (đã tính thuế VAT): " + chitra);
	}
	public double tinhVAT() {
		return 0.15;
	}
}