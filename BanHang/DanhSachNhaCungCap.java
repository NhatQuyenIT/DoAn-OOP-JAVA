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
public class DanhSachNhaCungCap {
    private ArrayList<NhaCungCap> dsNCC;

    public DanhSachNhaCungCap(ArrayList<NhaCungCap> ncc) {
        this.dsNCC = ncc;
    }
    public DanhSachNhaCungCap() {
        dsNCC=new ArrayList<>();
    }
    public void themNhaCungCap(NhaCungCap ncc ) {
        dsNCC.add(ncc);
        System.out.println("Them nha cung cap thanh cong");
    }
    public void xoaNhaCungCap(NhaCungCap ncc) {
        for(NhaCungCap ncc1:dsNCC) {
            if(ncc1.getTenNCC().equals(ncc.getTenNCC())) {
                dsNCC.remove(ncc1);
                System.out.println("Xoa thanh cong nha cung cap ma ban can");
                return ;
            }
        }
        System.out.println("Khong tim thay nha cung cap ma ban muon xoa ");
    }
    public NhaCungCap timNhaCungCap(NhaCungCap ncc) {
        for(NhaCungCap ncc1:dsNCC) {
            if(ncc1.getTenNCC().equals(ncc.getTenNCC())) {
                return ncc1;
            }
        }
        System.out.println("Khong tim thay");
        return null;
    }
    
}
