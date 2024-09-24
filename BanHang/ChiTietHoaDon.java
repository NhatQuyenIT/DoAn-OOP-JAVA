/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BanHang;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */

public class ChiTietHoaDon implements IXuat,INhap{
    private SanPham sanPham;
    private int soLuong;

    public ChiTietHoaDon(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    
    public ChiTietHoaDon() {
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return sanPham.getGiaSanPham() * soLuong;
    }

    public void xuat() {
        System.out.println("Sản phẩm: " + sanPham.getTenSanPham());
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + tinhThanhTien());
    }

    @Override
     public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập thông tin chi tiết sản phẩm:");

        // Nhập thông tin cho sản phẩm
        SanPham sp = new SanPham();
        sp.nhap();
        this.sanPham = sp;

        System.out.print("Nhập số lượng: ");
        this.soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước
    }
}

