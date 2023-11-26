package QLsieuthimini;

import java.util.Scanner;

public class Dogiadung extends SanPham implements INhap,IXuat{
	private String xuatxu; // nước nào? Trong hay ngoài nước? bếp từ, bếp hồng ngoại

	public Dogiadung() {
		super();
	}

	
	public Dogiadung(int masp, int soluongnhaphang, double tiennhaphang, double giasp, String tensp, String loaisp,
			NhaCungCap nhaCungCap, String xuatxu) {
		super(masp, soluongnhaphang, tiennhaphang, giasp, tensp, loaisp, nhaCungCap);
		this.xuatxu = xuatxu;
	}

	public String getXuatxu() {
		return xuatxu;
	}

	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}

@Override
	public void nhap() {
	Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập xuất xứ nguồn gốc đồ gia dụng: ");
		xuatxu = in.nextLine();
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Xuất xứ nguồn gốc đồ gia dụng: " +xuatxu);
		
		double tongGiaTri = getGiasp() + tinhVAT();
	    double chitra = tongGiaTri + getTiennhaphang();
		System.out.println("Tổng giá trị sản phẩm: " + chitra);
	}
	// Phương thức tính VAT
    public double tinhVAT() {
        double vat = 0.0;
        if (!xuatxu.equalsIgnoreCase("Việt Nam")) {
            vat = 0.2 * getGiasp();
        }
        return vat;
    }
}
