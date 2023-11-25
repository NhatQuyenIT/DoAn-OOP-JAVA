package QLsieuthimini;

import java.util.Scanner;

public class SanPham extends NhaCungCap implements INhap,IXuat{
	private int masp;
	private int soluongnhaphang;
	private String tensp;
	protected String loaisp;
	private double tiennhaphang;
	private double giasp;
	public SanPham() {
		super();
	}
	public SanPham(int masp, int soluongnhaphang,double tiennhaphang, double giasp, String tensp, String loaisp, int mancc, String tenncc, String diachincc, long sdtncc) {
		super(mancc, tenncc, diachincc,sdtncc);
		this.masp = masp;
		this.soluongnhaphang = soluongnhaphang;
		this.tensp = tensp;
		this.loaisp = loaisp;
		this.tiennhaphang = tiennhaphang;
		this.giasp = giasp;
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
	public double getGiasp() {
		return giasp;
	}
	public void setGiasp(double giasp) {
		this.giasp = giasp;
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
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã sản phẩm: ");
		masp = in.nextInt();
		System.out.println("Nhập số lượng nhập hàng: ");
		soluongnhaphang = in.nextInt();
		System.out.println("Nhập số tiền nhập hàng: ");
		tiennhaphang = in.nextDouble();
		System.out.println("Nhập giá tiền sản phẩm: ");
		giasp = in.nextDouble();
		in.nextLine();
		System.out.println("Nhập tên sản phẩm: ");
		tensp = in.nextLine();
		System.out.println("Nhập loại sản phẩm: ");
		loaisp = in.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("Mã sản phẩm: " + masp);
		System.out.println("Số lượng nhập hàng: " + soluongnhaphang);
		System.out.println("Giá tiền sản phẩm: " + giasp);
		System.out.println("Tên sản phẩm: " + tensp);
		System.out.println("Loại sản phẩm: " + loaisp);
		System.out.println("Số tiền nhập hàng: " + tiennhaphang);
	}
	@Override
	public String toString() {
		return "Mã sản phẩm: " + masp +
	            "\nSố lượng nhập hàng: " + soluongnhaphang +
	            "\nGiá tiền sản phẩm: " + giasp +
	            "\nTên sản phẩm: " + tensp +
	            "\nLoại sản phẩm: " + loaisp +
	            "\nSố tiền nhập hàng: " + tiennhaphang;
	}
	
}
