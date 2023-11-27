package QLsieuthimini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon  implements INhap,IXuat{
	private int mahoadon;
	private String ngaythanhtoan;
	private List<ChiTietHoaDon> chiTietHoaDonList;
	private KhachHang KhachHang;

	// Constructor không tham số
	public HoaDon() {
	    this.KhachHang = new KhachHang(); // Gán giá trị mặc định hoặc tạo đối tượng mới
	}

	    
	public HoaDon(int mahoadon, String ngaythanhtoan, KhachHang khachhang) {
		super();
		this.mahoadon = mahoadon;
		this.ngaythanhtoan = ngaythanhtoan;
		this.KhachHang = khachhang;
		this.chiTietHoaDonList = new ArrayList<>();
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getNgaythanhtoan() {
		return ngaythanhtoan;
	}
	public void setNgaythanhtoan(String ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}
	public List<ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
	    if (chiTietHoaDonList == null) {
	        chiTietHoaDonList = new ArrayList<>();
	    }
	    chiTietHoaDonList.add(chiTietHoaDon);
	}

	
	public KhachHang getKhachHang() {
		return KhachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		KhachHang = khachHang;
	}

	public void setChiTietHoaDonList(List<ChiTietHoaDon> chiTietHoaDonList) {
		this.chiTietHoaDonList = chiTietHoaDonList;
	}

	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã hóa đơn: ");
		mahoadon = in.nextInt();
		in.nextLine();
		System.out.println("Nhập ngày thanh toán: ");
		ngaythanhtoan = in.nextLine();
	}
	@Override
	public void xuat() {
	    System.out.println("Mã hóa đơn: " + this.mahoadon);
	    System.out.println("Ngày thanh toán: " + this.ngaythanhtoan);
	    System.out.println("Thông tin Khách hàng: ");
	    this.KhachHang.xuat();

	    if (this.chiTietHoaDonList != null && !this.chiTietHoaDonList.isEmpty()) {
	        double tongTien = tinhTongTien();
	        System.out.println("Tổng tiền: " + tongTien);

	        if (tongTien >= 600000) {
	            System.out.println("Xin chúc mừng, bạn đã được nhận voucher trị giá 100.000.");
	        }
	    }
	}

    public void sua() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã số hóa đơn mới: ");
        this.setMahoadon(in.nextInt());
        in.nextLine();
        System.out.println("Nhập ngày thanh toán hóa đơn mới: ");
        this.setNgaythanhtoan(in.nextLine());
    }
    
    public void nhapKhachHang() {
        // Sử dụng phương thức nhap() của KhachHang
        this.KhachHang.nhap();
    }
    
	// Phương thức tính tổng tiền
	public double tinhTongTien() {
        double tongTien = 0;
        if (chiTietHoaDonList != null) {
            for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
                tongTien += chiTietHoaDon.tinhThanhTien();
            }
        }
        return tongTien;
    }
}
