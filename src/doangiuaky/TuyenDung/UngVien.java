package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;
import java.util.ArrayList;v

public class UngVien {
    private String MaUngVien;
    private String HoTen;
    private String SDT;
    private LocalDate NgaySinh;
    private String MaDotTuyenDung;
    private String viTriUngTuyen;

    public UngVien() {}

    public UngVien(String MaUngVien, String HoTen, String SDT, LocalDate NgaySinh, String MaDotTuyenDung, String viTriUngTuyen) {
        this.MaUngVien = MaUngVien;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.viTriUngTuyen = viTriUngTuyen;
    }

    public String getMaUngVien() { return MaUngVien;}

    public void setMaUngVien(String MaUngVien) { this.MaUngVien = MaUngVien; }

    public String getHoTen() { return HoTen; }

    public void setHoTen(String HoTen) { this.HoTen = HoTen; }

    public String getSDT() { return SDT; }

    public void setSDT(String SDT) { this.SDT = SDT;}

    public LocalDate getNgaySinh() { return NgaySinh; }

    public void setNgaySinh(LocalDate NgaySinh) { this.NgaySinh = NgaySinh; }

    public String getMaDotTuyenDung() { return MaDotTuyenDung; }

    public void setMaDotTuyenDung(String MaDotTuyenDung) { this.MaDotTuyenDung = MaDotTuyenDung; }

    public String getViTriUngTuyen() { return viTriUngTuyen; }

    public void setViTriUngTuyen(String viTriUngTuyen) { this.viTriUngTuyen = viTriUngTuyen; }

    @Override
    public String toString() {
        return "Ma ung vien: " + MaUngVien + 
               ", Ho ten: " + HoTen + 
               ", SDT: " + SDT + 
               ", Ngay sinh: " + NgaySinh + 
               ", Ma dot tuyen dung: " + MaDotTuyenDung + 
               ", Vi tri ung tuyen: " + viTriUngTuyen;
    }
}
