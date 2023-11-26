package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSKhachHang {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<KhachHang> ds3;
	private static int makhtt;
	public DSKhachHang() {
		ds3 = new ArrayList<>();
	}

	public static int getMakhtt() {
		return makhtt;
	}

	public static void setMakhtt(int makhtt) {
		DSKhachHang.makhtt = makhtt;
	}
	
	public ArrayList<KhachHang> getDs3() {
		return ds3;
	}

	public void setDs3(ArrayList<KhachHang> ds3) {
		this.ds3 = ds3;
	}

	public void xem() {
		for(KhachHang kh : ds3) {
			kh.xuat();
		}
	}
	public void them() {
		KhachHang kh = null;
		kh = new KhachHang();
		if (kh != null) {
			kh.nhap();
			ds3.add(kh);
		}
	}
	public void sua() {
		  System.out.println("Nhập tên Khách hàng cần sửa: ");
	        String tenCanSua = scanner.nextLine();
	        for(KhachHang kh : ds3) {
	        	if (kh.getTenkh().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                kh.sua();
	                System.out.println("Đã sửa thông tin của nhân viên!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Không tìm thấy nhân viên cần sửa!");
	}
	public void xoa() {
		System.out.println("Nhập tên Khách hàng cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        for(KhachHang kh : ds3) {
        	if (kh.getTenkh().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                ds3.remove(kh);
                System.out.println("Đã xóa khách hàng!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy khách hàng cần xóa!");
	}
	public void timKiem() {
		System.out.println("Nhập tên Khách hàng cần tìm kiếm: ");
		String find = scanner.nextLine();
		boolean found = true;
		for(KhachHang kh : ds3) {
			if (kh.getTenkh().contains(find)) {
				kh.xuat();
			}
			if (!found) {
				System.out.println("Không có khách hàng tìm kiếm !");
			}
		}
	}
	public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng NhaCungCap và thêm vào danh sách
                KhachHang kh = parseLineToKhachHang(line);
                if (kh != null) {
                    ds3.add(kh);
                }
            }
            System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        	for(KhachHang kh : ds3) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseKhachHangToLine(kh));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng NhaCungCap
    private KhachHang parseLineToKhachHang(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            int makh = Integer.parseInt(parts[0]);
            long sdtkh = Long.parseLong(parts[1]);
            int sotuoikh = Integer.parseInt(parts[2]);
            String tenkh = parts[3];
            String diachikh = parts[4];
            String phaikh = parts[5];
            return new KhachHang(makh, sotuoikh, sdtkh, tenkh, diachikh, phaikh);
        }
        return null;
    }

    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseKhachHangToLine(KhachHang kh) {
        return kh.getMakh() + ";" + kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getDiachikh() + ";" + kh.getPhai() + ";" + kh.getSotuoi();
    }
}
