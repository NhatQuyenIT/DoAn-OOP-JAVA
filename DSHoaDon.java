package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSHoaDon {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<HoaDon> ds5;
	private static int mahdtt;
	// Khởi tạo danh sách sản phẩm trong constructor
    public DSHoaDon() {
        ds5 = new ArrayList<>();
    }

	public static int getMahdtt() {
		return mahdtt;
	}

	public static void setMahdtt(int mahdtt) {
		DSHoaDon.mahdtt = mahdtt;
	}

	public void xem() {
	    if (ds5 != null) {
	        for(HoaDon hd : ds5) {
	            hd.xuat();
	        }
	    } else {
	        System.out.println("Danh sách hóa đơn trống.");
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
	            parseLineToSanPham(line, dsKhachHang);
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
        	for(HoaDon hd : ds5) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng NhaCungCap
    private void parseLineToSanPham(String line, DSKhachHang dsKhachHang) {
        String[] parts = line.split(";");
        if (parts.length == 2) {
            int mahoadon = Integer.parseInt(parts[0]);       
            String ngaythanhtoan = parts[1];

            // Lấy thông tin nhà cung cấp từ danh sách
            KhachHang KhachHang = findKhachHangById(mahoadon, dsKhachHang);

            // Kiểm tra nếu tìm thấy nhà cung cấp
            if (KhachHang != null) {
                ds5.add(new HoaDon(mahoadon, ngaythanhtoan, KhachHang));
            }
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

 // Hàm chuyển đối tượng SanPham thành dòng văn bản
    private String parseHoaDonToLine(HoaDon hd) {
        // Lấy thông tin nhà cung cấp từ sản phẩm
        KhachHang kh = hd.getKhachhang();

        // Ghi đối tượng SanPham và NhaCungCap thành dòng văn bản và xuống dòng
        return hd.getMahoadon() + ";" + hd.getNgaythanhtoan() + ";" + kh.getMakh() + ";" + kh.getTenkh() + ";" +
        kh.getDiachikh() + ";" + kh.getSdtkh() + ";" + kh.getSotuoi() + ";" + kh.getPhai() + ":" + hd.tinhTongTien();
    }
}