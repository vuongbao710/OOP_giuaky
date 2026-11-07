package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.Arrays;

public class PhieuLuongCoBan extends PhieuLuong {
    private final long[] phuCapCoBan;

    public PhieuLuongCoBan(String maPL, NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong chamCong, long... phuCapCoBan) {
        super(maPL, nhanVien, thang.atDay(1), thang, chamCong, 0, 0);
        this.phuCapCoBan = Arrays.copyOf(phuCapCoBan, phuCapCoBan.length);
        validatePhuCap();
    }

    public PhieuLuongCoBan(String maPL, NhanVien nhanVien, LocalDate ngayLap,
            YearMonth thang, DanhSachChamCong chamCong, long... phuCapCoBan) {
        super(maPL, nhanVien, ngayLap, thang, chamCong, 0, 0);
        this.phuCapCoBan = Arrays.copyOf(phuCapCoBan, phuCapCoBan.length);
        validatePhuCap();
    }

    private void validatePhuCap() {
        for (long khoan : this.phuCapCoBan) {
            if (khoan < 0) {
                throw new IllegalArgumentException("Phu cap khong duoc am");
            }
        }
    }

    public long[] getPhuCapCoBan() {
        return Arrays.copyOf(phuCapCoBan, phuCapCoBan.length);
    }

    @Override
    public long tinhThucLinh() {
        long tongPhuCap = 0;
        for (long khoan : phuCapCoBan) tongPhuCap += khoan;
        return getLuongThucNhan() + tongPhuCap;
    }
}
