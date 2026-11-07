package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhieuLuongKinhDoanh extends PhieuLuong {
    private final ArrayList<Long> hoaHong;

    public PhieuLuongKinhDoanh(String maPL, NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong chamCong) {
        super(nhanVien, thang, chamCong, 0, 0);
        hoaHong = new ArrayList<>();
    }

    public PhieuLuongKinhDoanh(String maPL, NhanVien nhanVien, LocalDate ngayLap,
            YearMonth thang, DanhSachChamCong chamCong) {
        super(maPL, nhanVien, ngayLap, thang, chamCong, 0, 0);
        hoaHong = new ArrayList<>();
    }

    public void themHoaHong(long soTien) {
        if (soTien < 0) throw new IllegalArgumentException("Hoa hong khong duoc am");
        hoaHong.add(soTien);
    }

    public List<Long> getHoaHong() {
        return Collections.unmodifiableList(hoaHong);
    }

    @Override
    public long tinhThucLinh() {
        long tong = getLuongThucNhan();
        for (long khoan : hoaHong) tong += khoan;
        return tong;
    }
}
