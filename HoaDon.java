package QLsieuthimini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon  implements INhap,IXuat{
	private int mahoadon;
	private String ngaythanhtoan;
	private KhachHang khachhang;
	private List<ChiTietHoaDon> chiTietHoaDonList;
	
	public HoaDon() {
	}
	public HoaDon(int mahoadon, String ngaythanhtoan, KhachHang khachhang) {
		super();
		this.mahoadon = mahoadon;
		this.ngaythanhtoan = ngaythanhtoan;
		this.khachhang = khachhang;
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
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public List<ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        chiTietHoaDonList.add(chiTietHoaDon);
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
		System.out.println("Mã hóa đơn: " + mahoadon);
		System.out.println("Ngày thanh toán: " + ngaythanhtoan);
		System.out.println("Thông tin Khách hàng: " + "\n" + khachhang);
		if (!chiTietHoaDonList.isEmpty()) {
	        System.out.println("Thông tin Sản phẩm:");
	        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
	            System.out.println(chiTietHoaDon);
		}
	        double tongTien = tinhTongTien();
            System.out.println("Tổng tiền: " + tongTien);

            if (tongTien >= 600000) {
                System.out.println("Xin chúc mừng, bạn đã được nhận voucher trị giá 100.000.");
            }
	}
  }
	// Phương thức tính tổng tiền
    private double tinhTongTien() {
        double tongTien = 0;
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
            tongTien += chiTietHoaDon.tinhThanhTien();
        }
        return tongTien;
    }
    public void sua() { // ------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số hóa đơn mới: ");
        this.setMahoadon(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập ngày thanh toán hóa đơn mới: ");
        this.setNgaythanhtoan(scanner.nextLine());
    }
}
