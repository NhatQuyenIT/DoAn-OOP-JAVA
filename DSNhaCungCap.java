package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSNhaCungCap {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<NhaCungCap> ds1;
	private static int mancctt;
	public DSNhaCungCap() {
		ds1 = new ArrayList<>();
	}
	public static int getMancctt() {
		return mancctt;
	}
	public static void setMancctt(int mancctt) {
		DSNhaCungCap.mancctt = mancctt;
	}
	
	public ArrayList<NhaCungCap> getDs1() {
		return ds1;
	}
	public void setDs1(ArrayList<NhaCungCap> ds1) {
		this.ds1 = ds1;
	}
	public void xem() {
		for(NhaCungCap ncc : ds1) {
			ncc.xuat();
		}
	}
	public void them() {
		NhaCungCap ncc = null;
		ncc = new NhaCungCap();
		if (ncc != null) {
			ncc.nhap();
			ds1.add(ncc);
		}
	}
	public void sua() {
		  System.out.println("Nhập tên Nhà cung cấp cần sửa: ");
	        String tenCanSua = scanner.nextLine();
	        for(NhaCungCap ncc : ds1) {
	        	if (ncc.getTenncc().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                ncc.sua();
	                System.out.println("Đã sửa thông tin của nhà cung cấp!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Không tìm thấy tài liệu cần sửa!");
	}
	public void xoa() {
		System.out.println("Nhập tên Nhà cung cấp cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        for (NhaCungCap ncc : ds1) {
        	if (ncc.getTenncc().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                ds1.remove(ncc);
                System.out.println("Đã xóa nhà cung cấp!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy nhà cung cấp cần xóa!");
	}
	public void timKiem() {
		System.out.println("Nhập tên Nhà cung cấp cần tìm kiếm: ");
		String find = scanner.nextLine();
		boolean found = true;
		for (NhaCungCap ncc : ds1) {
			if (ncc.getTenncc().contains(find)) {
				ncc.xuat();
			}
			if (!found) {
				System.out.println("Không có nhà cung cấp tìm kiếm !");
			}
		}
	}
	public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng NhaCungCap và thêm vào danh sách
                NhaCungCap ncc = parseLineToNhaCungCap(line);
                if (ncc != null) {
                    ds1.add(ncc);
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
            for (NhaCungCap ncc : ds1) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseNhaCungCapToLine(ncc));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng NhaCungCap
    private NhaCungCap parseLineToNhaCungCap(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 4) {
            int mancc = Integer.parseInt(parts[0]);
            long sdtncc = Long.parseLong(parts[1]);
            String tenncc = parts[2];
            String diachincc = parts[3];
            return new NhaCungCap(mancc, tenncc, diachincc, sdtncc);
        }
        return null;
    }

    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseNhaCungCapToLine(NhaCungCap ncc) {
        return ncc.getMancc() + ";" + ncc.getSdtncc() + ";" + ncc.getTenncc() + ";" + ncc.getDiachincc();
    }
}
