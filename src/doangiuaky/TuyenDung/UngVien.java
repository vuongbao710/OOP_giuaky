package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;

public class UngVien {
    public static final String HINH_THUC_FULL_TIME = "Full time";
    public static final String HINH_THUC_PART_TIME = "Part time";

    private String MaUngVien;
    private String MaDotTuyenDung;
    private String MaViTriUngTuyen;
    private String CCCD;
    private String HoTen;
    private String SDT;
    private LocalDate NgayThangNamSinh;
    private String HinhThucLamViec; // Chỉ bao gồm "Full time" hoặc "Part time"

    public UngVien() {
    }

    public UngVien(String MaUngVien, String MaDotTuyenDung, String MaViTriUngTuyen, String CCCD, String HoTen, String SDT, LocalDate NgayThangNamSinh, String HinhThucLamViec) {
        this.MaUngVien = MaUngVien;
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.MaViTriUngTuyen = MaViTriUngTuyen;
        this.CCCD = CCCD;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.NgayThangNamSinh = NgayThangNamSinh;
        setHinhThucLamViec(HinhThucLamViec);
    }

    public String getMaUngVien() { return MaUngVien; }

    public void setMaUngVien(String MaUngVien) { this.MaUngVien = MaUngVien; }

    public String getMaDotTuyenDung() { return MaDotTuyenDung; }

    public void setMaDotTuyenDung(String MaDotTuyenDung) { this.MaDotTuyenDung = MaDotTuyenDung; }

    public String getMaViTriUngTuyen() { return MaViTriUngTuyen; }

    public void setMaViTriUngTuyen(String MaViTriUngTuyen) { this.MaViTriUngTuyen = MaViTriUngTuyen; }

    public String getCCCD() { return CCCD; }

    public void setCCCD(String CCCD) { this.CCCD = CCCD; }

    public String getHoTen() { return HoTen; }

    public void setHoTen(String HoTen) { this.HoTen = HoTen; }

    public String getSDT() { return SDT; }

    public void setSDT(String SDT) { this.SDT = SDT; }

    public LocalDate getNgayThangNamSinh() { return NgayThangNamSinh; }

    public void setNgayThangNamSinh(LocalDate NgayThangNamSinh) { this.NgayThangNamSinh = NgayThangNamSinh; }

    public String getHinhThucLamViec() { return HinhThucLamViec; }

    public void setHinhThucLamViec(String HinhThucLamViec) {
        if (HinhThucLamViec == null) {
            throw new IllegalArgumentException("Hinh thuc lam viec khong duoc de trong!");
        }
        String chuanHoa = HinhThucLamViec.trim().replace("-", " ");
        if (HINH_THUC_FULL_TIME.equalsIgnoreCase(chuanHoa) || "fulltime".equalsIgnoreCase(chuanHoa)) {
            this.HinhThucLamViec = HINH_THUC_FULL_TIME;
        } else if (HINH_THUC_PART_TIME.equalsIgnoreCase(chuanHoa) || "parttime".equalsIgnoreCase(chuanHoa)) {
            this.HinhThucLamViec = HINH_THUC_PART_TIME;
        } else {
            throw new IllegalArgumentException("Hinh thuc lam viec chi bao gom 'Full time' hoac 'Part time'!");
        }
    }

    @Override
    public String toString() {
        return "Ma ung vien: " + MaUngVien +
               ", Ma dot tuyen dung: " + MaDotTuyenDung +
               ", Ma vi tri ung tuyen: " + MaViTriUngTuyen +
               ", CCCD: " + CCCD +
               ", Ho ten: " + HoTen +
               ", SDT: " + SDT +
               ", Ngay sinh: " + NgayThangNamSinh +
               ", Hinh thuc lam viec: " + HinhThucLamViec;
    }
}
