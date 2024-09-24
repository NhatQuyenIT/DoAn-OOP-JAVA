/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BanHang;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap implements INhap,IXuat{
    private int maNCC;
    private String tenNCC;
    private String diaChiNCC;
    private int SDTNCC;
    private DanhSachSanPham dssp;
    @Override
    public void nhap() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma cung cap :  ");
        this.maNCC=sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ten nha cung cap :");
        this.tenNCC=sc.nextLine();
        System.out.print("Nhap dia chi nha cung cap :");
        this.diaChiNCC=sc.nextLine();
        System.out.print("Nhap so dien thoai nha cung cap :");
        this.SDTNCC=sc.nextInt();
    }
    @Override
    public void xuat() {
        System.out.println("Ma cung cap : "+this.maNCC);
        System.out.println("Ten cung cap : "+this.tenNCC);
        System.out.println("Dia chi nha cung cap :" +this.diaChiNCC);
        System.out.println("So dien thoai nha cung cap :"+this.SDTNCC);
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public int getSDTNCC() {
        return SDTNCC;
    }

    public void setSDTNCC(int SDTNCC) {
        this.SDTNCC = SDTNCC;
    }

    public NhaCungCap(int maNCC, String tenNCC, String diaChiNCC, int SDTNCC, DanhSachSanPham dssp) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChiNCC = diaChiNCC;
        this.SDTNCC = SDTNCC;
        this.dssp = dssp;
    }
    
    public NhaCungCap(){
    }
}
