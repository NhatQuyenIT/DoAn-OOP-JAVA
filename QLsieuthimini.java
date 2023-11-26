package QLsieuthimini;

import java.util.Scanner;

public class QLsieuthimini {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int select = in.nextInt();
		do {
			System.out.println("Menu:");
			System.out.println("1. Quản lý Nhà cung cấp");
            System.out.println("2. Quản lý Nhân viên");
            System.out.println("3. Quản lý Khách hàng");
            System.out.println("4. Quản lý Sản phẩm");
            System.out.println("5. Quản lý Hóa đơn");

			switch(select) {
			case 1:
				QLNhaCungCap ql1 = new QLNhaCungCap();
				ql1.menu();
			case 2:
				QLNhanVien ql2 = new QLNhanVien();
				ql2.menu();
			case 3:
				QLKhachHang ql3 = new QLKhachHang();
				ql3.menu();
			case 4:
				QLSanPham ql4 = new QLSanPham();
				ql4.menu();
			case 5:
				QLHoaDon ql5 = new QLHoaDon();
				ql5.menu();
			default:
	            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		} while (select != 5);
	}
}
