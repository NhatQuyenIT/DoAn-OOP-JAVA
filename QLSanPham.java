package QLsieuthimini;

import java.util.Scanner;

class QLSanPham {
	private DSSanPham dssp;
    Scanner scanner = new Scanner(System.in);
    String fileName = "SanPham.txt";
    String fileName2 = "SanPham_full.txt";
    String fileNameNhaCungCap = "NhaCungCap.txt";
    DSNhaCungCap dsNhaCungCap;
 // Thêm constructor để khởi tạo dsNhaCungCap từ dữ liệu có sẵn
    public QLSanPham() {
        dsNhaCungCap = new DSNhaCungCap();
        dsNhaCungCap.taiDanhSachTuFile(fileNameNhaCungCap); // Tải danh sách nhà cung cấp từ file
        dssp = new DSSanPham();
    }

    public void menu() {
        int choice;
        do {
        	System.out.println("1. Thêm Sản phẩm");
            System.out.println("2. Sửa thông tin Sản phẩm");
            System.out.println("3. Xóa Sản phẩm");
            System.out.println("4. Tìm kiếm Sản phẩm");
            System.out.println("5. Xem thông tin trong danh sách Sản Phẩm");
            System.out.println("6. Tải danh sách Sản phẩm từ file");
            System.out.println("7. Xuất danh sách Sản phẩm ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dssp.them();
	                break;
                case 2:
                	dssp.sua();
                    break;
                case 3:
                	dssp.xoa();
                    break;
                case 4:
                	dssp.timKiem();
                    break;
                case 5:
                	dssp.xem();
                    break;
                case 6:
                    dssp.taiDanhSachTuFile(fileName, dsNhaCungCap);
                    break;
                case 7:            
                    dssp.xuatDanhSachRaFile(fileName2);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
