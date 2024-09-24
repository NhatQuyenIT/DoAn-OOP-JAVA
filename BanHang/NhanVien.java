package com.mycompany.BanHang;

import java.util.Scanner;

public class NhanVien implements INhap, IXuat {
    private int maNV;
    private String tenNV;
    private String diaChiNV;
    private int SDT;
    private String chucVu;

    public NhanVien(int maNV, String tenNV, String diaChiNV, int SDT, String chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChiNV = diaChiNV;
        this.SDT = SDT;
        this.chucVu = chucVu;
    }

    public NhanVien() {
        // Constructor mặc định
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã nhân viên: ");
        this.maNV = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        System.out.print("Nhập tên nhân viên: ");
        this.tenNV = scanner.nextLine();

        System.out.print("Nhập địa chỉ nhân viên: ");
        this.diaChiNV = scanner.nextLine();

        System.out.print("Nhập số điện thoại nhân viên: ");
        this.SDT = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        System.out.print("Nhập chức vụ nhân viên: ");
        this.chucVu = scanner.nextLine();
    }

    @Override
    public void xuat() {
        System.out.println("Thông tin nhân viên:");
        System.out.println("Mã nhân viên: " + maNV);
        System.out.println("Tên nhân viên: " + tenNV);
        System.out.println("Địa chỉ nhân viên: " + diaChiNV);
        System.out.println("Số điện thoại nhân viên: " + SDT);
        System.out.println("Chức vụ nhân viên: " + chucVu);
    }
}
