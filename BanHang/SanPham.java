package com.mycompany.BanHang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class SanPham {
    private String tenSanPham;
    private String maSanPham;
    private double giaSanPham;
    private int soLuong;
    private String maNgayCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate hanSuDung;

    // Constructor
    public SanPham(String tenSanPham, String maSanPham, double giaSanPham, int soLuong,
                   String maNgayCungCap, LocalDate ngaySanXuat, LocalDate hanSuDung) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuong = soLuong;
        this.maNgayCungCap = maNgayCungCap;
        this.ngaySanXuat = ngaySanXuat;
        this.hanSuDung = hanSuDung;
    }

    public SanPham() {
    }
    
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public double getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaNgayCungCap() {
        return maNgayCungCap;
    }

    public void setMaNgayCungCap(String maNgayCungCap) {
        this.maNgayCungCap = maNgayCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    
    public void xuat() {
        System.out.println("Thông tin sản phẩm:");
        System.out.println("Tên sản phẩm: " + tenSanPham);
        System.out.println("Mã sản phẩm: " + maSanPham);
        System.out.println("Giá sản phẩm: " + giaSanPham);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Mã ngày cung cấp: " + maNgayCungCap);
        System.out.println("Ngày sản xuất: " + ngaySanXuat);
        System.out.println("Hạn sử dụng: " + hanSuDung);
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhập tên sản phẩm: ");
        this.tenSanPham = scanner.nextLine();

        System.out.print("Nhập mã sản phẩm: ");
        this.maSanPham = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        this.giaSanPham = scanner.nextDouble();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        System.out.print("Nhập số lượng sản phẩm: ");
        this.soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        System.out.print("Nhập mã ngày cung cấp: ");
        this.maNgayCungCap = scanner.nextLine();

        System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
        String ngaySX = scanner.nextLine();
        this.ngaySanXuat = LocalDate.parse(ngaySX, formatter);

        System.out.print("Nhập hạn sử dụng (dd/MM/yyyy): ");
        String hanSD = scanner.nextLine();
        this.hanSuDung = LocalDate.parse(hanSD, formatter);
    }

    public abstract void giamGia(double phanTram);
}
