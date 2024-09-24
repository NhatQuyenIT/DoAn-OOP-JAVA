package com.mycompany.BanHang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon implements INhap, IXuat {
    private int maHoaDon;
    private LocalDate ngayLap;
    private NhanVien nhanVien;
    private List<ChiTietHoaDon> chiTietHoaDon;

    public HoaDon() {
        chiTietHoaDon = new ArrayList<>();
    }

    public HoaDon(int maHoaDon, LocalDate ngayLap, NhanVien nhanVien, List<ChiTietHoaDon> chiTietHoaDon) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.nhanVien = nhanVien;
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public List<ChiTietHoaDon> getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã hóa đơn: ");
        this.maHoaDon = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        System.out.print("Nhập ngày lập hóa đơn (yyyy-MM-dd): ");
        String ngayLapStr = scanner.nextLine();
        this.ngayLap = LocalDate.parse(ngayLapStr);

        // Nhập thông tin nhân viên
        NhanVien nv = new NhanVien();
        nv.nhap();
        this.nhanVien = nv;

        // Nhập chi tiết hóa đơn
        System.out.print("Nhập số lượng chi tiết hóa đơn: ");
        int soLuongChiTiet = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ trước

        for (int i = 0; i < soLuongChiTiet; i++) {
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
            chiTiet.nhap();
            chiTietHoaDon.add(chiTiet);
        }
    }

    @Override
    public void xuat() {
        System.out.println("Thông tin hóa đơn:");
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Ngày lập hóa đơn: " + ngayLap);
        System.out.println("Thông tin nhân viên:");
        nhanVien.xuat();

        System.out.println("Danh sách chi tiết hóa đơn:");
        for (ChiTietHoaDon chiTiet : chiTietHoaDon) {
            chiTiet.xuat();
        }
    }
}
