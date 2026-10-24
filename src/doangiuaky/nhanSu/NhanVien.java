package doangiuaky.nhanSu;

import java.time.LocalDate;

public abstract class NhanVien {
    private String MaNV;       
    private String HoTen;
    private LocalDate NgaySinh;
    private String SDT;
    private String MaPhongBan;    
    private LocalDate NgayVaoLam;
    private String ChucVu;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, LocalDate NgaySinh, String ChucVu, String SDT, String MaPhongBan, LocalDate NgayVaoLam) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.MaPhongBan = MaPhongBan;
        this.NgayVaoLam = NgayVaoLam;
    }

    public abstract long tinhLuongThucTe();

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public LocalDate getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(LocalDate NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    @Override
    public String toString() {
        return "Ma NV: " + MaNV + ", Ho ten: " + HoTen + ", Ngay sinh: " + NgaySinh + ", Chuc vu: " + ChucVu + ", So dien thoai: " + SDT + ", Ma phong ban: " + MaPhongBan + ", Ngay vao lam: " + NgayVaoLam + ", Luong co ban: " + tinhLuongThucTe();
    }
}
