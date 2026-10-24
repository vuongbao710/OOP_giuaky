package doangiuaky.nhanSu;

import java.util.ArrayList;

public class PhongBan {
    private String MaPhongBan;
    private String TenPhongBan;
    private String MaTruongPhong;
    private String TenTruongPhong;
    private ArrayList<NhanVien> DanhSachNhanVien;

    public PhongBan() {
        this.DanhSachNhanVien = new ArrayList<>();
    }

    public PhongBan(String MaPhongBan, String TenPhongBan, String MaTruongPhong, String TenTruongPhong) {
        this.MaPhongBan = MaPhongBan;
        this.TenPhongBan = TenPhongBan;
        this.MaTruongPhong = MaTruongPhong;
        this.TenTruongPhong = TenTruongPhong;
        this.DanhSachNhanVien = new ArrayList<>();
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public String getTenPhongBan() {
        return TenPhongBan;
    }

    public void setTenPhongBan(String TenPhongBan) {
        this.TenPhongBan = TenPhongBan;
    }

    public String getMaTruongPhong() {
        return MaTruongPhong;
    }

    public void setMaTruongPhong(String MaTruongPhong) {
        this.MaTruongPhong = MaTruongPhong;
    }

    public String getTenTruongPhong() {
        return TenTruongPhong;
    }

    public void setTenTruongPhong(String TenTruongPhong) {
        this.TenTruongPhong = TenTruongPhong;
    }

    public ArrayList<NhanVien> getdanhsachnhanvien() {
        return DanhSachNhanVien;
    }

    public void setdanhsachnhanvien(ArrayList<NhanVien> danhsachnhanvien) {
        this.DanhSachNhanVien = danhsachnhanvien;
    }
    @Override
    public String toString() {
        return "Ma phong ban: " + MaPhongBan + ", Ten phong ban: " + TenPhongBan + ", Ma truong phong: " + MaTruongPhong + ", Ten truong phong: " + TenTruongPhong;
    }
}
