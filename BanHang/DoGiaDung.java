package com.mycompany.BanHang;

import java.time.LocalDate;
import java.util.Scanner;

public class DoGiaDung extends SanPham implements IXuat, INhap {

    public DoGiaDung(String tenSanPham, String maSanPham, double giaSanPham, int soLuong, String maNgayCungCap, LocalDate ngaySanXuat, LocalDate hanSuDung) {
        super(tenSanPham, maSanPham, giaSanPham, soLuong, maNgayCungCap, ngaySanXuat, hanSuDung);
    }

    public void giamGia(double phanTram) {
        double giaMoi = getGiaSanPham() - phanTram * getGiaSanPham();
        setGiaSanPham(giaMoi);
    }

    @Override
    public void xuat() {
        System.out.println("Thông tin đồ gia dụng:");
        super.xuat();
        System.out.println("VAT: " + tinhVAT(10)); // Giả sử VAT là 10%
        System.out.println("-----------------------------");
    }

    public double tinhVAT(double phanTramVAT) {
        return getGiaSanPham() * phanTramVAT / 100;
    }

    @Override
    public void nhap() {
       super.nhap();
    }
}
