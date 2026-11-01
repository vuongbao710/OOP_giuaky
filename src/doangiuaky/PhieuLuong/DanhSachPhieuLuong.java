package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachPhieuLuong {
    private final ArrayList<PhieuLuong> danhSach;

    public DanhSachPhieuLuong() {
        danhSach = new ArrayList<>();
    }

    public PhieuLuong lapPhieu(NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong danhSachChamCong, long phuCap, long khauTru) {
        PhieuLuong phieuLuong = new PhieuLuong(
                nhanVien, thang, danhSachChamCong, phuCap, khauTru);
        danhSach.add(phieuLuong);
        return phieuLuong;
    }

    public List<PhieuLuong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public PhieuLuong tim(String maNhanVien, YearMonth thang) {
        for (PhieuLuong phieuLuong : danhSach) {
            if (phieuLuong.getNhanVien().getMaNV().equalsIgnoreCase(maNhanVien)
                    && phieuLuong.getThang().equals(thang)) {
                return phieuLuong;
            }
        }
        return null;
    }

    public void xuat() {
        for (PhieuLuong phieuLuong : danhSach) {
            phieuLuong.xuat();
        }
    }
}
