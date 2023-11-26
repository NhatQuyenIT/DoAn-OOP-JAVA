package QLsieuthimini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon  implements INhap,IXuat{
	private int mahoadon;
	private String ngaythanhtoan;
	private List<ChiTietHoaDon> chiTietHoaDonList;
	private KhachHang KhachHang;
	 
	// Thêm các thuộc tính từ KhachHang
    private int makh;
    private String tenkh;
	private int sotuoi;
    private String diachikh;
    private long sdtkh;
	private String phai;

	 // Constructor không tham số
	    public HoaDon() {
	        this.KhachHang = new KhachHang();
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
	public KhachHang getKhachhang() {
		return KhachHang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.KhachHang = khachhang;
	}
	public List<ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        chiTietHoaDonList.add(chiTietHoaDon);
    }
	
	public KhachHang getKhachHang() {
		return KhachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		KhachHang = khachHang;
	}

	public int getMakh() {
		return makh;
	}

	public void setMakh(int makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public int getSotuoi() {
		return sotuoi;
	}

	public void setSotuoi(int sotuoi) {
		this.sotuoi = sotuoi;
	}

	public String getDiachikh() {
		return diachikh;
	}

	public void setDiachikh(String diachikh) {
		this.diachikh = diachikh;
	}

	public long getSdtkh() {
		return sdtkh;
	}

	public void setSdtkh(long sdtkh) {
		this.sdtkh = sdtkh;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
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
		System.out.println("Mã hóa đơn: " + mahoadon);
		System.out.println("Ngày thanh toán: " + ngaythanhtoan);
		System.out.println("Thông tin Khách hàng: " + "\n" + KhachHang);
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
    public void sua() { // ------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số hóa đơn mới: ");
        this.setMahoadon(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập ngày thanh toán hóa đơn mới: ");
        this.setNgaythanhtoan(scanner.nextLine());
    }
	public void nhapKhachHang() {
		// Tạo đối tượng KhachHang và gọi phương thức nhap() của nó
        KhachHang kh = new KhachHang();
        kh.nhap();
        
        // Gán thông tin khách hàng cho sản phẩm
        setMakh(kh.getMakh());
        setTenkh(kh.getTenkh());
        setDiachikh(kh.getDiachikh());
        setSdtkh(kh.getSdtkh());
        setSotuoi(kh.getSotuoi());
        setPhai(kh.getPhai());
	}
	// Phương thức tính tổng tiền
	public double tinhTongTien() {
        double tongTien = 0;
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
            tongTien += chiTietHoaDon.tinhThanhTien();
        }
        return tongTien;
    }
}
