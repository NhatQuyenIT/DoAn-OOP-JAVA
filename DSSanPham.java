package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSSanPham {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<SanPham> ds4;
	private static int masptt;
	// Khởi tạo danh sách sản phẩm trong constructor
    public DSSanPham() {
        ds4 = new ArrayList<>();
    }
	public static int getMasptt() {
		return masptt;
	}

	public static void setMasptt(int masptt) {
		DSSanPham.masptt = masptt;
	}

	public void xem() {
	    if (ds4 != null) {
	        for(SanPham sp : ds4) {
	            sp.xuat();
	        }
	    } else {
	        System.out.println("Danh sách sản phẩm trống.");
	    }
	}

	public void them() {
        SanPham sp = new SanPham();
        if (sp != null) {
            // Trước khi thêm sản phẩm mới, nhập thông tin nhà cung cấp
            sp.nhapNhaCungCap();

            // Sau đó nhập thông tin sản phẩm
            sp.nhap();

            ds4.add(sp);
        }
    }
	public void sua() {
		  System.out.println("Nhập tên Sản phẩm cần sửa: ");
	        String tenCanSua = scanner.nextLine();
	        for(SanPham sp : ds4) {
	        	if (sp.getTensp().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                sp.sua();
	                System.out.println("Đã sửa thông tin của sản phẩm!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Không tìm thấy sản phẩm cần sửa!");
	}
	public void xoa() {
		System.out.println("Nhập tên Sản phẩm cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        for(SanPham sp : ds4) {
        	if (sp.getTensp().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                ds4.remove(sp);
                System.out.println("Đã xóa sản phẩm!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy sản phẩm cần xóa!");
	}
	public void timKiem() {
		System.out.println("Nhập tên Sản phẩm cần tìm kiếm: ");
		String find = scanner.nextLine();
		boolean found = true;
		for(SanPham sp : ds4) {
			if (sp.getTensp().contains(find)) {
				sp.xuat();
			}
			if (!found) {
				System.out.println("Không có sản phẩm tìm kiếm !");
			}
		}
	}
	public void taiDanhSachTuFile(String fileName, DSNhaCungCap dsNhaCungCap) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Đảm bảo bạn đã truyền dsNhaCungCap vào hàm
	            parseLineToSanPham(line, dsNhaCungCap);
	        }
	        System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
	        // Kiểm tra xem danh sách có dữ liệu không
	        if (ds4.isEmpty()) {
	            System.out.println("Danh sách sản phẩm trống.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Không tìm thấy tệp tin: " + fileName);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


    public void xuatDanhSachRaFile(String fileName2) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
        	for(SanPham sp : ds4) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseSanPhamToLine(sp));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng NhaCungCap
    private void parseLineToSanPham(String line, DSNhaCungCap dsNhaCungCap) {
        String[] parts = line.split(";");
        if (parts.length == 6) {
            int masp = Integer.parseInt(parts[0]);
            int soluongnhaphang = Integer.parseInt(parts[1]);
            double tiennhaphang = Double.parseDouble(parts[2]);
            double giasp = Double.parseDouble(parts[3]);
            String tensp = parts[4];
            String loaisp = parts[5];

            // Lấy thông tin nhà cung cấp từ danh sách
            NhaCungCap nhaCungCap = findNhaCungCapById(masp, dsNhaCungCap);

            // Kiểm tra nếu tìm thấy nhà cung cấp
            if (nhaCungCap != null) {
                ds4.add(new SanPham(masp, soluongnhaphang, tiennhaphang, giasp, tensp, loaisp, nhaCungCap));
            }
        }
    }
    
    // Thêm phương thức để tìm nhà cung cấp theo mã
    private NhaCungCap findNhaCungCapById(int mancc, DSNhaCungCap dsNhaCungCap) {
        for (NhaCungCap ncc : dsNhaCungCap.getDs1()) {
            if (ncc.getMancc() == mancc) {
                return ncc;
            }
        }
        return null;
    }

 // Hàm chuyển đối tượng SanPham thành dòng văn bản
    private String parseSanPhamToLine(SanPham sp) {
        // Lấy thông tin nhà cung cấp từ sản phẩm
        NhaCungCap ncc = sp.getNhaCungCap();

        // Ghi đối tượng SanPham và NhaCungCap thành dòng văn bản và xuống dòng
        return sp.getMasp() + ";" + sp.getSoluongnhaphang() + ";" + sp.getTiennhaphang() + ";" +
                sp.getGiasp() + ";" + sp.getTensp() + ";" + sp.getLoaisp() + ";" +
                ncc.getMancc() + ";" + ncc.getTenncc() + ";" + ncc.getDiachincc() + ";" + ncc.getSdtncc();
    }
}
