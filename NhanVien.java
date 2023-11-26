package QLsieuthimini;

import java.util.Scanner;

public class NhanVien implements INhap,IXuat{
	private int manv;
	private String tennv;
	private String diachinv;
	private long sdtnv;
	private String phai;
	private String chucvu;
	public NhanVien() {
		
	}
	public NhanVien(int manv, String tennv, String diachinv, long sdtnv, String phai, String chucvu) {
		this.manv = manv;
		this.tennv = tennv;
		this.diachinv = diachinv;
		this.sdtnv = sdtnv;
		this.phai = phai;
		this.chucvu = chucvu;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getDiachinv() {
		return diachinv;
	}
	public void setDiachinv(String diachinv) {
		this.diachinv = diachinv;
	}
	public long getSdtnv() {
		return sdtnv;
	}
	public void setSdtnv(long sdtnv) {
		this.sdtnv = sdtnv;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã số nhân viên: ");
		manv = in.nextInt();
		System.out.println("Nhập số điện thoại nhân viên: ");
		sdtnv = in.nextLong();
		in.nextLine();
		System.out.println("Nhập Họ và tên nhân viên: ");
		tennv = in.nextLine();
		System.out.println("Nhập giới tính nhân viên: ");
		phai = in.nextLine();
		System.out.println("Nhập chức vụ: ");
		chucvu = in.nextLine();
		System.out.println("Nhập địa chỉ nhân viên: ");
		diachinv = in.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("Mã số nhân viên: " + manv);
		System.out.println("Họ và tên nhân viên: " + tennv);
		System.out.println("Giới tính nhân viên: " + phai);
		System.out.println("Chức vụ: " + chucvu);
		System.out.println("Số điện thoại nhân viên: " +sdtnv);
		System.out.println("Địa chỉ nhân viên: " + diachinv);
	}
	public void sua() { // ------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số nhân viên mới: ");
        this.setManv(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên nhân viên mới: ");
        this.setTennv(scanner.nextLine());
        System.out.println("Nhập số điện thoại nhân viên mới: ");
        this.setSdtnv(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Nhập giới tính nhân viên mới: ");
        this.setPhai(scanner.nextLine());
        System.out.println("Nhập chức vụ nhân viên mới: ");
        this.setChucvu(scanner.nextLine());
        System.out.println("Nhập địa chỉ nhà cung cấp mới: ");
        this.setDiachinv(scanner.nextLine());
    }
}
