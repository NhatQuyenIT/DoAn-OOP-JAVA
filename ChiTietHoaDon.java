package QLsieuthimini;

public class ChiTietHoaDon {
	private SanPham sanpham;
    private int soluongmua;
	public ChiTietHoaDon() {
		
	}
	public ChiTietHoaDon(SanPham sanpham, int soluongmua) {
		this.sanpham = sanpham;
		this.soluongmua = soluongmua;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	public double tinhThanhTien() {
        return sanpham.getGiasp() * soluongmua;
    }
	public void xuat() {
        System.out.println("Mã sản phẩm: " + this.sanpham.getMasp());
        System.out.println("Số lượng mua: " + this.soluongmua);
        System.out.println("Thành tiền: " + String.format("%.2f", this.tinhThanhTien()));
        System.out.println("-------------------------");
    }
//	@Override
//    public String toString() {
//        return sanpham.getTensp() +
//                "\nSố lượng mua: " + soluongmua +
//                "\nThành tiền: " + tinhThanhTien();
//	}
//	
}
