package QLsieuthimini;

import java.util.Scanner;

public class QLHoaDon {
    private DSHoaDon dshd;
    private DSSanPham dsSanPham;
    private DSKhachHang dsKhachHang;
    private Scanner scanner = new Scanner(System.in);
    private final String FILE_NAME = "HoaDon.txt";
    private final String FILE_NAME_FULL = "HoaDon_full.txt";
    private final String FILE_NAME_KHACHHANG = "KhachHang.txt";

    // Thêm constructor để khởi tạo dsNhaCungCap từ dữ liệu có sẵn
    public QLHoaDon() {
        dsSanPham = new DSSanPham();
        dsKhachHang = new DSKhachHang();
        dsKhachHang.taiDanhSachTuFile(FILE_NAME_KHACHHANG); // Tải danh sách nhà cung cấp từ file
        // Truyền DSSanPham vào constructor DSHoaDon
        dshd = new DSHoaDon(dsSanPham);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Thêm Hóa đơn");
            System.out.println("2. Sửa thông tin Hóa đơn");
            System.out.println("3. Xóa Hóa đơn");
            System.out.println("4. Tìm kiếm Hóa đơn");
            System.out.println("5. Xem thông tin trong danh sách Hóa đơn");
            System.out.println("6. Tải danh sách Hóa đơn từ file");
            System.out.println("7. Xuất danh sách Hóa đơn ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
                case 1:
                    themHoaDon();
                    break;
                case 2:
                    suaHoaDon();
                    break;
                case 3:
                    xoaHoaDon();
                    break;
                case 4:
                    timKiemHoaDon();
                    break;
                case 5:
                    xemDanhSachHoaDon();
                    break;
                case 6:
                    taiDanhSachHoaDonTuFile();
                    break;
                case 7:
                    xuatDanhSachHoaDonRaFile();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }

    private void themHoaDon() {
        dshd.them();
    }

    private void suaHoaDon() {
        dshd.sua();
    }

    private void xoaHoaDon() {
        dshd.xoa();
    }

    private void timKiemHoaDon() {
        dshd.timKiem();
    }

    private void xemDanhSachHoaDon() {
        dshd.xem();
    }

    private void taiDanhSachHoaDonTuFile() {
        dshd.taiDanhSachTuFile(FILE_NAME, dsKhachHang);
    }

    private void xuatDanhSachHoaDonRaFile() {
        dshd.xuatDanhSachRaFile(FILE_NAME_FULL);
    }
}