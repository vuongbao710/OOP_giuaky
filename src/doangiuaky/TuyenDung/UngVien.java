package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;

public class UngVien {
    private String MaUngVien;
    private String MaDotTuyenDung;
    private String MaViTriUngTuyen;
    private String CCCD;
    private String HoTen;
    private String SDT;
    private LocalDate NgayThangNamSinh;

    public UngVien() {
    }

    public UngVien(String MaUngVien, String MaDotTuyenDung, String MaViTriUngTuyen, String CCCD, String HoTen, String SDT, LocalDate NgayThangNamSinh) {
        this.MaUngVien = MaUngVien;
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.MaViTriUngTuyen = MaViTriUngTuyen;
        this.CCCD = CCCD;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.NgayThangNamSinh = NgayThangNamSinh;
    }

    public String getMaUngVien() {
        return MaUngVien;
    }

    public void setMaUngVien(String MaUngVien) {
        this.MaUngVien = MaUngVien;
    }

    public String getMaDotTuyenDung() {
        return MaDotTuyenDung;
    }

    public void setMaDotTuyenDung(String MaDotTuyenDung) {
        this.MaDotTuyenDung = MaDotTuyenDung;
    }

    public String getMaViTriUngTuyen() {
        return MaViTriUngTuyen;
    }

    public void setMaViTriUngTuyen(String MaViTriUngTuyen) {
        this.MaViTriUngTuyen = MaViTriUngTuyen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public LocalDate getNgayThangNamSinh() {
        return NgayThangNamSinh;
    }

    public void setNgayThangNamSinh(LocalDate NgayThangNamSinh) {
        this.NgayThangNamSinh = NgayThangNamSinh;
    }

    @Override
    public String toString() {
        return "Ma ung vien: " + MaUngVien +
               ", Ma dot tuyen dung: " + MaDotTuyenDung +
               ", Ma vi tri ung tuyen: " + MaViTriUngTuyen +
               ", CCCD: " + CCCD +
               ", Ho ten: " + HoTen +
               ", SDT: " + SDT +
               ", Ngay sinh: " + NgayThangNamSinh;
    }
}
