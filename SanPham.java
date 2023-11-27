package QLsieuthimini;

import java.util.Scanner;

public class SanPham implements INhap,IXuat{
	private int masp;
	private int soluongnhaphang;
	private String tensp;
	protected String loaisp;
	private double tiennhaphang;
	private double giasp;
	private NhaCungCap nhaCungCap; // Sử dụng composition 
	
	// Thêm các thuộc tính từ NhaCungCap
    private int mancc;
    private String tenncc;
    private String diachincc;
    private long sdtncc;
    
	 // Constructor không tham số
	    public SanPham() {
	        this.nhaCungCap = new NhaCungCap();
	    }

	    // Constructor có tham số
	    public SanPham(int masp, int soluongnhaphang, double tiennhaphang, double giasp, String tensp, String loaisp, NhaCungCap nhaCungCap) {
	        this.masp = masp;
	        this.soluongnhaphang = soluongnhaphang;
	        this.tensp = tensp;
	        this.loaisp = loaisp;
	        this.tiennhaphang = tiennhaphang;
	        this.giasp = giasp;
	        this.nhaCungCap = nhaCungCap;
	    }

	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getSoluongnhaphang() {
		return soluongnhaphang;
	}
	public void setSoluongnhaphang(int soluongnhaphang) {
		this.soluongnhaphang = soluongnhaphang;
	}
	public double getGiasp() {
		return giasp;
	}
	public void setGiasp(double giasp) {
		this.giasp = giasp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getLoaisp() {
		return loaisp;
	}
	public void setLoaisp(String loaisp) {
		this.loaisp = loaisp;
	}
	public double getTiennhaphang() {
		return tiennhaphang;
	}
	public void setTiennhaphang(double tiennhaphang) {
		this.tiennhaphang = tiennhaphang;
	}
	
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public int getMancc() {
		return mancc;
	}

	public void setMancc(int mancc) {
		this.mancc = mancc;
	}

	public String getTenncc() {
		return tenncc;
	}

	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}

	public String getDiachincc() {
		return diachincc;
	}

	public void setDiachincc(String diachincc) {
		this.diachincc = diachincc;
	}

	public long getSdtncc() {
		return sdtncc;
	}

	public void setSdtncc(long sdtncc) {
		this.sdtncc = sdtncc;
	}

	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập mã sản phẩm: ");
		masp = in.nextInt();
		System.out.println("Nhập số lượng nhập hàng: ");
		soluongnhaphang = in.nextInt();
		System.out.println("Nhập số tiền nhập hàng: ");
		tiennhaphang = in.nextDouble();
		System.out.println("Nhập giá tiền sản phẩm: ");
		giasp = in.nextDouble();
		in.nextLine();
		System.out.println("Nhập tên sản phẩm: ");
		tensp = in.nextLine();
		System.out.println("Nhập loại sản phẩm: ");
		loaisp = in.nextLine();
		// Nhập thông tin nhà cung cấp
        nhaCungCap.nhap();
	}
	@Override
	public void xuat() {
		System.out.println("Mã sản phẩm: " + masp);
		System.out.println("Số lượng nhập hàng: " + soluongnhaphang);
		System.out.println("Giá tiền sản phẩm: " + giasp);
		System.out.println("Tên sản phẩm: " + tensp);
		System.out.println("Loại sản phẩm: " + loaisp);
		System.out.println("Số tiền nhập hàng: " + tiennhaphang);
		// Hiển thị thông tin nhà cung cấp
        nhaCungCap.xuat();
	}
	@Override
	public String toString() {
		return "Mã sản phẩm: " + masp +
	            "\nSố lượng nhập hàng: " + soluongnhaphang +
	            "\nGiá tiền sản phẩm: " + giasp +
	            "\nTên sản phẩm: " + tensp +
	            "\nLoại sản phẩm: " + loaisp +
	            "\nSố tiền nhập hàng: " + tiennhaphang;
	}
    public void sua() {
        // Sửa thông tin mã sản phẩm, tên sản phẩm, loại sản phẩm, số lượng nhập hàng, giá tiền, và thông tin nhà cung cấp
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã số sản phẩm mới: ");
        this.setMasp(in.nextInt());
        in.nextLine();
        System.out.println("Nhập tên sản phẩm mới: ");
        this.setTensp(in.nextLine());
        System.out.println("Nhập loại sản phẩm mới: ");
        this.setLoaisp(in.nextLine());
        System.out.println("Nhập số lượng nhập hàng sản phẩm mới: ");
        this.setSoluongnhaphang(in.nextInt());
        System.out.println("Nhập số tiền nhập hàng sản phẩm mới: ");
        this.setTiennhaphang(in.nextDouble());
        System.out.println("Nhập giá tiền của sản phẩm mới: ");
        this.setGiasp(in.nextDouble());

        // Sửa thông tin nhà cung cấp
        nhaCungCap.sua();
    }
    public void nhapNhaCungCap() {
        // Tạo đối tượng NhaCungCap và gọi phương thức nhap() của nó
        NhaCungCap ncc = new NhaCungCap();
        ncc.nhap();
        
        // Gán thông tin nhà cung cấp cho sản phẩm
        setMancc(ncc.getMancc());
        setTenncc(ncc.getTenncc());
        setDiachincc(ncc.getDiachincc());
        setSdtncc(ncc.getSdtncc());
    }
}