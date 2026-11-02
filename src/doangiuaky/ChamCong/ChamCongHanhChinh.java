package doangiuaky.ChamCong;

import java.time.YearMonth;
import java.util.Arrays;

public class ChamCongHanhChinh extends ChamCong {
    private final int[] ngayCong;

    public ChamCongHanhChinh(String maCC, String maNV, YearMonth thangNam) {
        this(maCC, maNV, thangNam, new int[0]);
    }

    public ChamCongHanhChinh(String maCC, String maNV, YearMonth thangNam, int[] ngayCong) {
        super(maCC, maNV, thangNam);
        this.ngayCong = new int[thangNam.lengthOfMonth()];
        for (int ngay : ngayCong) {
            if (ngay < 1 || ngay > this.ngayCong.length) {
                throw new IllegalArgumentException("Ngay cong khong hop le");
            }
            this.ngayCong[ngay - 1] = 1;
        }
    }

    public void themNgayCong(int ngay) {
        if (ngay < 1 || ngay > ngayCong.length) {
            throw new IllegalArgumentException("Ngay cong khong hop le");
        }
        ngayCong[ngay - 1] = 1;
    }

    public int[] getNgayCong() {
        return Arrays.copyOf(ngayCong, ngayCong.length);
    }

    @Override
    public double tinhNgayCongThucTe() {
        int tong = 0;
        for (int ngay : ngayCong) {
            tong += ngay;
        }
        return tong;
    }
}
