package QLsieuthimini;

public class ChiTietHoaDon {
	private SanPham sanPham;
    private int soluongmua;
 // Thêm các thuộc tính từ SanPham
 	private int masp;
 	private int soluongnhaphang;
 	private String tensp;
 	protected String loaisp;
 	private double tiennhaphang;
 	private double giasp;
	public ChiTietHoaDon() {
		this.sanPham = new SanPham();
	}
	
	public ChiTietHoaDon(SanPham sanPham, int soluongmua, int masp, int soluongnhaphang, String tensp, String loaisp,
			double tiennhaphang, double giasp) {
		super();
		this.sanPham = sanPham;
		this.soluongmua = soluongmua;
		this.masp = masp;
		this.soluongnhaphang = soluongnhaphang;
		this.tensp = tensp;
		this.loaisp = loaisp;
		this.tiennhaphang = tiennhaphang;
		this.giasp = giasp;
	}

	public SanPham getSanpham() {
		return sanPham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanPham = sanpham;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
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

	@Override
    public String toString() {
        return sanPham.getMasp() + sanPham.getTensp() +
                "\n Số lượng mua: " + soluongmua;
	}
	public double tinhTien() {
	    if (this.sanPham != null) {
	        return this.sanPham.getGiasp() * this.soluongmua;
	    } else {
	        // Trả về 0 hoặc một giá trị mặc định tùy thuộc vào logic của bạn
	        return 0.0;
	    }
	}

	
}
