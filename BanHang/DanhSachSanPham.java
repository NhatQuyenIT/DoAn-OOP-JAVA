/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BanHang;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DanhSachSanPham {
    private ArrayList<SanPham> qly;

    public DanhSachSanPham() {
        qly=new ArrayList<>();
    }

    public DanhSachSanPham(ArrayList<SanPham> qly) {
        this.qly = qly;
    }
    
    public void xemThongTinSanPham(String name) {
        for(SanPham sp:qly) {
            if(sp.getTenSanPham().equals((name))) {
                sp.xuat();
            }
        }
    }
    public void themSanPham(SanPham sp) {
        qly.add(sp);
    }
    public void xoaSanPham(SanPham sp1) {
        for(SanPham sp:qly) {
            if(sp.getTenSanPham().equals(sp1.getTenSanPham())) {
                qly.remove(sp);
            }
        }
    }
    public void xuatThongTinSanPham() {
        for(SanPham sp:qly ) {
            sp.xuat();
        }
    }
    public void giamGia(SanPham sp,double giam) {
        double tienMoi=sp.getGiaSanPham()-giam*sp.getGiaSanPham();
        sp.setGiaSanPham(tienMoi);
    }
    public  SanPham timSanPham(SanPham sp) {
        for(SanPham sp1:qly) {
            if(sp1.getTenSanPham().equals(sp.getTenSanPham())) {
                return sp1;
            }
        }
        System.out.println("Khong tim thay san pham ");
        return null;
    }
    public SanPham sanPhamTiepTheo(SanPham sp) {
        int index = qly.indexOf(sp);

        // Nếu không tìm thấy sản phẩm hoặc là sản phẩm cuối cùng, trả về null hoặc xử lý tùy ý
        if (index == -1 || index == qly.size() - 1) {
            return null; // hoặc throw new SomeException("Không tìm thấy hoặc là sản phẩm cuối cùng");
        }

        // Trả về sản phẩm tiếp theo
        return qly.get(index + 1);
    }
 
}
