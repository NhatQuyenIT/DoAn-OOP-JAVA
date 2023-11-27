package QLsieuthimini;

import java.util.Scanner;

public class HoaDon implements INhap,IXuat{
	private int mahoadon;
	private String ngaythanhtoan;
	private KhachHang khachHang;
	private SanPham sanPham;
	private ChiTietHoaDon chiTietHoaDon;
	// Thêm các thuộc tính từ KhachHang
	private int makh;
	private int sotuoi;
	private long sdtkh;
	private String tenkh;
	private String diachikh;
	private String phai;
	// Thêm các thuộc tính từ SanPham
	private int masp;
	private int soluongnhaphang;
	private String tensp;
	protected String loaisp;
	private double tiennhaphang;
	private double giasp;
	// Thêm các thuộc tính từ ChiTietHoaDon
    private int soluongmua;
	
	public HoaDon() {
		this.khachHang = new KhachHang();
		this.sanPham = new SanPham();
		this.chiTietHoaDon = new ChiTietHoaDon();
	}
	public HoaDon(int mahoadon, String ngaythanhtoan, KhachHang khachHang, SanPham sanPham, ChiTietHoaDon chiTietHoaDon) {
		this.mahoadon = mahoadon;
		this.ngaythanhtoan = ngaythanhtoan;
		this.khachHang = khachHang;
		this.sanPham = sanPham;
		this.chiTietHoaDon = chiTietHoaDon;
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
	// ---
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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
	
	
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getSoluongnhaphang() {
		return soluongnhaphang;
	}
	public void setSoluongnhaphang(int soluongnhaphang) {
		this.soluongnhaphang = soluongnhaphang;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getLoaisp() {
		return loaisp;
	}
	public void setLoaisp(String loaisp) {
		this.loaisp = loaisp;
	}
	public double getTiennhaphang() {
		return tiennhaphang;
	}
	public void setTiennhaphang(double tiennhaphang) {
		this.tiennhaphang = tiennhaphang;
	}
	public double getGiasp() {
		return giasp;
	}
	public void setGiasp(double giasp) {
		this.giasp = giasp;
	}
	
	public ChiTietHoaDon getChiTietHoaDon() {
		return chiTietHoaDon;
	}
	public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	@Override
	public void xuat() {
		System.out.println("Mã hóa đơn: " + mahoadon);
		System.out.println("Ngày thanh toán: " + ngaythanhtoan);
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
	public String toString() {
		return "Mã hóa đơn: " + mahoadon +
	            "\nNgày lập hóa đơn: " + ngaythanhtoan;
	}
    public void sua() {
        // Sửa thông tin mã hóa đơn, ngày thanh toán và thông tin khách hàng
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số hóa đơn mới: ");
        this.setMahoadon(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập ngày thanh toán mới: ");
        this.setNgaythanhtoan(scanner.nextLine());
        
        // Sửa thông tin khách hàng
        khachHang.sua();
    }
	public void nhapKhachHang() {
		// Tạo đối tượng KhachHang và gọi phương thức nhap() của nó
        KhachHang kh = new KhachHang();
        kh.nhap();
        
        // Gán thông tin nhà cung cấp cho sản phẩm
        setMakh(kh.getMakh());
        setTenkh(kh.getTenkh());
        setSotuoi(kh.getSotuoi());
        setPhai(kh.getPhai());
        setSdtkh(kh.getSdtkh());
        setDiachikh(kh.getDiachikh());
	}
	
}
