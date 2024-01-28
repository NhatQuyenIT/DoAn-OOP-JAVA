package QLsieuthimini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHoaDon {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<HoaDon> ds5;
	private static int mahdtt;
	private SanPham sanPham;
	private Thucpham thucPham;
	private Douong doUong;
	private Dogiadung doGiaDung;
	private ArrayList<KhachHang> dsKhachHang;
	private ArrayList<SanPham> dsSanPham;
	public DSHoaDon() {
		ds5 = new ArrayList<>();
	}
	
	public DSHoaDon(Thucpham thucPham, Douong doUong, Dogiadung doGiaDung, SanPham sanPham) {
		this.thucPham = thucPham;
		this.doUong = doUong;
		this.doGiaDung = doGiaDung;
		this.sanPham = sanPham;
	}

	public ArrayList<HoaDon> getDs5() {
		return ds5;
	}
	public void setDs5(ArrayList<HoaDon> ds5) {
		this.ds5 = ds5;
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
	            // In thông tin hóa đơn
	            System.out.println("Mã hóa đơn: " + hd.getMahoadon());
	            System.out.println("Ngày thanh toán: " + hd.getNgaythanhtoan());
	            
	            // In thông tin khách hàng
	            KhachHang kh = hd.getKhachHang();
	            System.out.println("Thông tin Khách hàng: ");
	            System.out.println("Mã số khách hàng: " + kh.getMakh());
	            System.out.println("Họ và tên khách hàng: " + kh.getTenkh());
	            System.out.println("Giới tính khách hàng: " + kh.getPhai());
	            System.out.println("Số tuổi: " + kh.getSotuoi());
	            System.out.println("Số điện thoại khách hàng: " + kh.getSdtkh());
	            System.out.println("Địa chỉ khách hàng: " + kh.getDiachikh());
	            
	            // In chi tiết hóa đơn
	            System.out.println("Chi tiết hóa đơn:");
	            ChiTietHoaDon cthd = hd.getChiTietHoaDon();
	            SanPham sp = hd.getSanPham();
	            System.out.println("Mã sản phẩm: " + sp.getMasp());
	            System.out.println("Tên sản phẩm: " + sp.getTensp());
	            System.out.println("Số luợng mua: " + cthd.getSoluongmua());
	            System.out.println("Giá sản phẩm: " + sp.getGiasp());
	            
	            System.out.println("----------------------------");
	            
	            // In thành tiền
	            tinhThanhTien(cthd);  // Gọi phương thức tính thành tiền
	            System.out.println("===============\n");
	        }
	    } else {
	        System.out.println("Danh sách hóa đơn trống.");
	    }
	}
	public void them() {
        HoaDon hd = new HoaDon();
        if (hd != null) {
            // Trước khi thêm sản phẩm mới, nhập thông tin khách hàng
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
//	public void xoa() {
//	    System.out.println("Nhập mã Hóa đơn cần xóa: ");
//	    int maCanXoa = scanner.nextInt();
//	    for (HoaDon hd : ds5) {
//	        if (hd.getMahoadon() == maCanXoa) {
//	            ds5.remove(hd);
//	            System.out.println("Đã xóa hóa đơn!");
//	            return;
//	        }
//	    }
//	    System.out.println("Không tìm thấy hóa đơn cần xóa!");
//	}
	public void timKiem() {
		System.out.println("Nhập mã Hóa đơn cần tìm kiếm: ");
		int find = scanner.nextInt();
		boolean found = true;
		for(HoaDon hd : ds5) {
			if (hd.getMahoadon() == find) {
				hd.xuat();
			}
			if (!found) {
				System.out.println("Không có Hóa đơn tìm kiếm !");
			}
		}
	}
	public double tinhThue() {
	    // Kiểm tra xem sanPham có giá trị hay không
	    if (sanPham != null) {
	        // Kiểm tra xem loaisp có giá trị hay không
	        if (sanPham.loaisp != null) {
	            if (sanPham.loaisp.equalsIgnoreCase("thực phẩm")) {
	                return thucPham.tinhVAT();
	            } else if (sanPham.loaisp.equalsIgnoreCase("đồ uống")) {
	                return doUong.tinhVAT();
	            }
	            return doGiaDung.tinhVAT();
	        } else {
	            // Xử lý nếu loaisp là null
	            System.out.println("Loại sản phẩm không xác định.");
	        }
	    } else {
	        // Xử lý nếu sanPham là null
	        System.out.println("Không có sản phẩm để tính thuế.");
	    }
	    // Trả về giá trị mặc định hoặc thích hợp theo logic của bạn
	    return 0.0;
	}

	// Phương thức tính thành tiền và in ra màn hình
	private void tinhThanhTien(ChiTietHoaDon cthd) {
	    double thanhTien = cthd.tinhTien() + tinhThue() * cthd.tinhTien();
	    System.out.println("Thành tiền: " + thanhTien);
	}
	public KhachHang timKiemKhachHangTheoMa(int maKhachHang) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMakh() == maKhachHang) {
                return kh;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
	public SanPham timKiemSanPhamTheoMa(int maSanPham) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMasp() == maSanPham) {
                return sp;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
	public void taiDanhSachTuFile(String fileName, DSKhachHang dsKhachHang, DSSanPham dsSanPham) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
             // Tạo đối tượng HoaDon từ thông tin trong file
                HoaDon hd = new HoaDon();
                hd.setMahoadon(Integer.parseInt(parts[0]));
                hd.setNgaythanhtoan(parts[1]);

                // Tạo đối tượng KhachHang từ DSKhachHang
                int maKhachHang = Integer.parseInt(parts[2]);
                KhachHang kh = dsKhachHang.timKiemKhachHangTheoMa(maKhachHang);
                hd.setKhachHang(kh);

                // Tạo đối tượng ChiTietHoaDon từ thông tin trong file
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                
                cthd.setSoluongmua(Integer.parseInt(parts[3]));

                // Tạo đối tượng SanPham từ DSSanPham
                int maSanPham = Integer.parseInt(parts[2]);
                SanPham sp = dsSanPham.timKiemSanPhamTheoMa(maSanPham);
                cthd.setSanpham(sp);

                hd.setChiTietHoaDon(cthd);

                // Thêm HoaDon vào danh sách
                ds5.add(hd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void xuatDanhSachRaFile(String fileName2) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
        	for(HoaDon hd : ds5) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	private String parseHoaDonToLine(HoaDon hd) {
        // Lấy thông tin nhà cung cấp từ sản phẩm
        KhachHang kh = hd.getKhachHang();
        SanPham sp = hd.getSanPham();
        ChiTietHoaDon cthd = hd.getChiTietHoaDon();
        
        // Ghi các đối tượng thành dòng văn bản và xuống dòng
        return hd.getMahoadon() + ";" + hd.getNgaythanhtoan() + ";" + kh.getMakh() + ";" + kh.getTenkh() + ";" + kh.getSotuoi() +
        kh.getDiachikh() + ";" + kh.getSdtkh() + ";" + sp.getMasp() + sp.getTensp() + ";" + cthd.getSoluongmua() + ";" ;
    }
	
	public void xoa() {
		System.out.println("Nhập mã hóa đơn cần xóa: ");
		int maCanXoa = scanner.nextInt();
				for (HoaDon hd : ds5) {
					if (hd.getMahoadon() == maCanXoa) {
						ds5.remove(hd);
						System.out.println("Đã xóa hóa đơn!");
						return;
					}
				}
				System.out.println("Không tìm thấy hóa đơn để xóa!");
	}
	
}
