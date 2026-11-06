package doangiuaky.nhanSu;

import doangiuaky.Enum.LoaiChucVu;
import java.time.LocalDate;

public abstract class NhanVien {
    private String MaNV;
    private String CCCD;
    private String HoTen;
    private String SDT;
    private String MaPhongBan;
    private String MaQuanLyPhuTrach;
    private LocalDate NgaySinh;
    private LocalDate NgayVaoLam;
    private LoaiChucVu ChucVu;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String CCCD, String HoTen, String SDT, String MaPhongBan, String MaQuanLyPhuTrach, LocalDate NgaySinh, LocalDate NgayVaoLam, String ChucVu) {
        this.MaNV = MaNV;
        this.CCCD = CCCD;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.MaPhongBan = MaPhongBan;
        this.MaQuanLyPhuTrach = MaQuanLyPhuTrach;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.ChucVu = LoaiChucVu.NhanDien(ChucVu);
    }

    

    public abstract double TinhLuongThucTe();

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

    public LoaiChucVu getChucVu() {
        return ChucVu;
    }
    
    public String getMoTaChucVu(){
        return ChucVu.getMoTa();
    }

    public void setChucVu(LoaiChucVu ChucVu) {
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
        return "Ma NV: " + MaNV + ", Ho ten: " + HoTen 
                + ", Ngay sinh: " + NgaySinh + ", Chuc vu: " 
                + ChucVu + ", So dien thoai: " + SDT + ", Ma phong ban: " 
                + MaPhongBan + ", Ngay vao lam: " + NgayVaoLam + ", Luong co ban: " + TinhLuongThucTe();
    }
}
