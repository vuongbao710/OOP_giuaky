package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.Arrays;

public class PhieuLuongThuongPhat extends PhieuLuong {
    private final long[] thuongPhat;

    public PhieuLuongThuongPhat(String maPL, NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong chamCong, long... thuongPhat) {
        super(nhanVien, thang, chamCong, 0, 0);
        this.thuongPhat = Arrays.copyOf(thuongPhat, thuongPhat.length);
    }

    public PhieuLuongThuongPhat(String maPL, NhanVien nhanVien, LocalDate ngayLap,
            YearMonth thang, DanhSachChamCong chamCong, long... thuongPhat) {
        super(maPL, nhanVien, ngayLap, thang, chamCong, 0, 0);
        this.thuongPhat = Arrays.copyOf(thuongPhat, thuongPhat.length);
    }

    public long[] getThuongPhat() {
        return Arrays.copyOf(thuongPhat, thuongPhat.length);
    }

    @Override
    public long tinhThucLinh() {
        long tong = getLuongThucNhan();
        for (long khoan : thuongPhat) tong += khoan;
        return tong;
    }
}
