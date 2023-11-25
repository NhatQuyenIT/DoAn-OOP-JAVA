package QLsieuthimini;

import java.util.Scanner;

public class NhaCungCap implements INhap,IXuat{
	private int mancc;
	private String tenncc;
	private String diachincc;
	private long sdtncc;
	public NhaCungCap() {
		
	}
	public NhaCungCap(int mancc, String tenncc, String diachincc, long sdtncc) {
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.diachincc = diachincc;
		this.sdtncc = sdtncc;
	}
	public int getMancc() {
		return mancc;
	}
	public void setMancc(int mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public String getDiachincc() {
		return diachincc;
	}
	public void setDiachincc(String diachincc) {
		this.diachincc = diachincc;
	}
	public long getSdtncc() {
		return sdtncc;
	}
	public void setSdtncc(long sdtncc) {
		this.sdtncc = sdtncc;
	}
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã số nhà cung cấp: ");
		mancc = in.nextInt();
		System.out.println("Nhập số điện thoại nhà cung cấp: ");
		sdtncc = in.nextLong();
		in.nextLine();
		System.out.println("Nhập tên nhà cung cấp: ");
		tenncc = in.nextLine();
		System.out.println("Nhập địa chỉ nhà cung cấp: ");
		diachincc = in.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("Mã số nhà cung cấp: " + mancc);
		System.out.println("Tên nhà cung cấp: " + tenncc);
		System.out.println("Địa chỉ nhà cung cấp: " +diachincc);
		System.out.println("Số điện thoại nhà cung cấp: " + sdtncc);
	}
}
