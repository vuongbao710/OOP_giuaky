package doangiuaky.ChamCong;

import java.time.YearMonth;
import java.util.Arrays;

public class ChamCongCaDacBiet extends ChamCong {
    private final double[] gioTangCa;
    private final boolean[] ngayLe;

    public ChamCongCaDacBiet(String maCC, String maNV, YearMonth thangNam) {
        super(maCC, maNV, thangNam);
        this.gioTangCa = new double[thangNam.lengthOfMonth()];
        this.ngayLe = new boolean[thangNam.lengthOfMonth()];
    }

    public void ghiNhan(int ngay, double gio, boolean ngayLe) {
        if (ngay < 1 || ngay > gioTangCa.length || gio < 0) {
            throw new IllegalArgumentException("Du lieu ca dac biet khong hop le");
        }
        gioTangCa[ngay - 1] = gio;
        this.ngayLe[ngay - 1] = ngayLe;
    }

    public double[] getGioTangCa() {
        return Arrays.copyOf(gioTangCa, gioTangCa.length);
    }

    public boolean[] getNgayLe() {
        return Arrays.copyOf(ngayLe, ngayLe.length);
    }

    @Override
    public double tinhNgayCongThucTe() {
        double tong = 0;
        for (int i = 0; i < gioTangCa.length; i++) {
            tong += ngayLe[i] ? 1 : (gioTangCa[i] > 0 ? 1 : 0);
            tong += gioTangCa[i] / 8.0;
        }
        return tong;
    }
}
