package doangiuaky.ChamCong;

import java.time.YearMonth;
import java.util.Objects;

public abstract class ChamCong {
    private String maCC;
    private String maNV;
    private YearMonth thangNam;

    protected ChamCong(String maCC, String maNV, YearMonth thangNam) {
        this.maCC = batBuoc(maCC, "Ma cham cong");
        this.maNV = batBuoc(maNV, "Ma nhan vien");
        this.thangNam = Objects.requireNonNull(thangNam, "Thang nam khong duoc null");
    }

    private static String batBuoc(String giaTri, String ten) {
        if (giaTri == null || giaTri.trim().isEmpty()) {
            throw new IllegalArgumentException(ten + " khong duoc rong");
        }
        return giaTri.trim();
    }

    public String getMaCC() { return maCC; }
    public String getMaNV() { return maNV; }
    public YearMonth getThangNam() { return thangNam; }

    public void suaThongTin(String maNV, YearMonth thangNam) {
        this.maNV = batBuoc(maNV, "Ma nhan vien");
        this.thangNam = Objects.requireNonNull(thangNam, "Thang nam khong duoc null");
    }

    public abstract double tinhNgayCongThucTe();
}
