package doangiuaky.ChamCong;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BangChamCong {
    private static int soThuTuTiepTheo = 1;

    private final String maBang;
    private final YearMonth thangNam;
    private final ArrayList<ChiTietChamCong> danhSach;

    public BangChamCong() {
        this(YearMonth.now());
    }

    public BangChamCong(YearMonth thangNam) {
        if (thangNam == null) {
            throw new IllegalArgumentException("Thang nam khong duoc null");
        }
        this.maBang = "BCC-" + thangNam.toString().replace("-", "")
                + "-" + String.format("%04d", soThuTuTiepTheo++);
        this.thangNam = thangNam;
        this.danhSach = new ArrayList<>();
    }

    public String getMaBang() {
        return maBang;
    }

    public YearMonth getThangNam() {
        return thangNam;
    }

    public void them(ChiTietChamCong chiTiet) {
        if (chiTiet == null) {
            throw new IllegalArgumentException("Chi tiet cham cong khong duoc null");
        }
        if (!YearMonth.from(chiTiet.getNgay()).equals(thangNam)) {
            throw new IllegalArgumentException("Chi tiet cham cong khong thuoc thang cua bang");
        }
        if (tim(chiTiet.getMaNhanVien(), chiTiet.getNgay()) != null) {
            throw new IllegalArgumentException("Nhan vien da co cham cong trong ngay nay");
        }
        danhSach.add(chiTiet);
    }

    public ChiTietChamCong tim(String maNhanVien, java.time.LocalDate ngay) {
        if (maNhanVien == null || ngay == null) {
            return null;
        }
        for (ChiTietChamCong chiTiet : danhSach) {
            if (chiTiet.getMaNhanVien().equalsIgnoreCase(maNhanVien)
                    && chiTiet.getNgay().equals(ngay)) {
                return chiTiet;
            }
        }
        return null;
    }

    public List<ChiTietChamCong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public double tinhTongSoGioLam(String maNhanVien) {
        double tong = 0;
        for (ChiTietChamCong chiTiet : danhSach) {
            if (chiTiet.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                tong += chiTiet.getSoGioLam();
            }
        }
        return tong;
    }
}
