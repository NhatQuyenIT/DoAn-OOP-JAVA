package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

class DSHoaDon {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<HoaDon> ds5;
	private static int mahdtt;
	private DSSanPham dsSanPham;
	 
	public DSHoaDon() {
		ds5 = new ArrayList<>();
	}

	public DSHoaDon(DSSanPham dsSanPham) {
	    this.dsSanPham = dsSanPham;
	    ds5 = new ArrayList<>();
	}

	public static int getMahdtt() {
		return mahdtt;
	}

	public static void setMahdtt(int mahdtt) {
		DSHoaDon.mahdtt = mahdtt;
	}

	public void xem() {
	    if (ds5 != null && !ds5.isEmpty()) {
	        for (HoaDon hd : ds5) {
	            hd.xuat();
	            System.out.println("Chi tiết hóa đơn:");
	            for (ChiTietHoaDon chiTiet : hd.getChiTietHoaDonList()) {
	                System.out.println("Mã sản phẩm: " + chiTiet.getSanpham().getMasp());
	                System.out.println("Số lượng mua: " + chiTiet.getSoluongmua());
	                System.out.println("Thành tiền: " + chiTiet.tinhThanhTien());
	                System.out.println("-------------------------");
	            }
	            System.out.println("===================================");
	        }
	    } else {
	        System.out.println("Danh sách hóa đơn trống hoặc không có dữ liệu.");
	    }
	}

	public void them() {
        HoaDon hd = new HoaDon();
        if (hd != null) {
            // Trước khi thêm sản phẩm mới, nhập thông tin nhà cung cấp
            hd.nhapKhachHang();

            // Sau đó nhập thông tin sản phẩm
            hd.nhap();

            ds5.add(hd);
        }
    }
	public void sua() {
	    System.out.println("Nhập mã Hóa đơn cần sửa: ");
	    int maCanSua = scanner.nextInt();
	    for (HoaDon hd : ds5) {
	        if (hd.getMahoadon() == maCanSua) {
	            hd.sua();
	            System.out.println("Đã sửa thông tin của hóa đơn!");
	            return;
	        }
	    }
	    System.out.println("Không tìm thấy hóa đơn cần sửa!");
	}

	public void xoa() {
	    System.out.println("Nhập mã Hóa đơn cần xóa: ");
	    int maCanXoa = scanner.nextInt();
	    for (HoaDon hd : ds5) {
	        if (hd.getMahoadon() == maCanXoa) {
	            ds5.remove(hd);
	            System.out.println("Đã xóa hóa đơn!");
	            return;
	        }
	    }
	    System.out.println("Không tìm thấy hóa đơn cần xóa!");
	}

    public void timKiem() {
        System.out.println("Nhập mã hóa đơn cần tìm kiếm: ");
        int find = scanner.nextInt();
        boolean found = false;
        for(HoaDon hd : ds5) {
            if (hd.getMahoadon() == find) {
                hd.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có hóa đơn tìm kiếm!");
        }
    }

	public void taiDanhSachTuFile(String fileName, DSKhachHang dsKhachHang) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Đảm bảo bạn đã truyền dsNhaCungCap vào hàm
	            parseLineToSanPham(line, dsKhachHang, dsSanPham);
	        }
	        System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
	        // Kiểm tra xem danh sách có dữ liệu không
	        if (ds5.isEmpty()) {
	            System.out.println("Danh sách hóa đơn trống.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Không tìm thấy tệp tin: " + fileName);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


	public void xuatDanhSachRaFile(String fileName2) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            for (HoaDon hd : ds5) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLineToSanPham(String line, DSKhachHang dsKhachHang, DSSanPham dsSanPham) {
        String[] parts = line.split(";");
        
        // Kiểm tra xem có đủ phần tử hay không
        if (parts.length >= 8) {
            // Không đủ phần tử để tạo Hóa đơn
            return;
        }

        try {
            int mahoadon = Integer.parseInt(parts[0]);
            String ngaythanhtoan = parts[1];

            // Lấy thông tin khách hàng từ danh sách
            KhachHang khachHang = findKhachHangById(mahoadon, dsKhachHang);

            // Kiểm tra nếu tìm thấy khách hàng
            if (khachHang != null) {
                HoaDon hoaDon = new HoaDon(mahoadon, ngaythanhtoan, khachHang);

                // Đọc thông tin chi tiết hóa đơn
                for (int i = 2; i < parts.length; i++) {
                    String[] chiTietParts = parts[i].split(";");

                    // Kiểm tra xem có đủ phần tử trong chi tiết hóa đơn không
                    if (chiTietParts.length == 2) {
                        int maSanPham = Integer.parseInt(chiTietParts[0]);
                        int soLuongMua = Integer.parseInt(chiTietParts[1]);

                        // Tìm sản phẩm trong danh sách
                        SanPham sanPham = findSanPhamById(maSanPham, dsSanPham);

                        // Kiểm tra nếu tìm thấy sản phẩm
                        if (sanPham != null) {
                            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, soLuongMua);
                            hoaDon.themChiTietHoaDon(chiTietHoaDon);
                        }
                    }
                }

                ds5.add(hoaDon);
            }
        } catch (NumberFormatException e) {
            // Xử lý nếu có lỗi chuyển đổi kiểu số
            System.out.println("Lỗi chuyển đổi kiểu số: " + e.getMessage());
        }
    }
    
    // Thêm phương thức để tìm nhà cung cấp theo mã
    private KhachHang findKhachHangById(int makh, DSKhachHang dsKhachHang) {
        for (KhachHang kh : dsKhachHang.getDs3()) {
            if (kh.getMakh() == makh) {
                return kh;
            }
        }
        return null;
    }
    // Thêm phương thức để tìm sản phẩm theo mã
    private SanPham findSanPhamById(int maSanPham, DSSanPham dsSanPham) {
        for (SanPham sanPham : dsSanPham.getDs4()) {
            if (sanPham.getMasp() == maSanPham) {
                return sanPham;
            }
        }
        return null;
    }

 // Hàm chuyển đối tượng HoaDon thành dòng văn bản
    private String parseHoaDonToLine(HoaDon hd) {
        StringJoiner line = new StringJoiner(";");

        line.add(String.valueOf(hd.getMahoadon()))
            .add(hd.getNgaythanhtoan());

        KhachHang kh = hd.getKhachHang();
        line.add(String.valueOf(kh.getMakh()))
            .add(kh.getTenkh())
            .add(kh.getDiachikh())
            .add(String.valueOf(kh.getSdtkh()))
            .add(String.valueOf(kh.getSotuoi()))
            .add(kh.getPhai());

        if (hd.getChiTietHoaDonList() != null) {
            for (ChiTietHoaDon chiTiet : hd.getChiTietHoaDonList()) {
                line.add(String.format("%d:%d", chiTiet.getSanpham().getMasp(), chiTiet.getSoluongmua()));
            }
        }

        return line.toString();
    }
}