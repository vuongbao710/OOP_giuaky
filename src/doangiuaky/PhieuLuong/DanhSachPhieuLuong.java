package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachPhieuLuong {
    private final ArrayList<PhieuLuong> danhSach = new ArrayList<>();

    public PhieuLuong lapPhieu(NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong danhSachChamCong, long phuCap, long khauTru) {
        if (nhanVien == null || thang == null) {
            throw new IllegalArgumentException("Nhan vien va thang khong duoc null");
        }
        if (tim(nhanVien.getMaNV(), thang) != null) {
            throw new IllegalArgumentException("Nhan vien da co phieu luong trong thang nay");
        }
        PhieuLuong phieuLuong = new PhieuLuong(
                nhanVien, thang, danhSachChamCong, phuCap, khauTru);
        danhSach.add(phieuLuong);
        return phieuLuong;
    }

    public void them(PhieuLuong phieuLuong) {
        if (phieuLuong == null) {
            throw new IllegalArgumentException("Phieu luong khong duoc null");
        }
        if (tim(phieuLuong.getMaNV(), phieuLuong.getThang()) != null
                || timTheoMa(phieuLuong.getMaPL()) != null) {
            throw new IllegalArgumentException("Phieu luong da ton tai");
        }
        danhSach.add(phieuLuong);
    }

    public List<PhieuLuong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public PhieuLuong tim(String maNhanVien, YearMonth thang) {
        if (maNhanVien == null || thang == null) {
            return null;
        }
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaNV().equalsIgnoreCase(maNhanVien)
                    && phieu.getThang().equals(thang)) {
                return phieu;
            }
        }
        return null;
    }

    public PhieuLuong timTheoMa(String maPL) {
        if (maPL == null) {
            return null;
        }
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaPL().equalsIgnoreCase(maPL)) {
                return phieu;
            }
        }
        return null;
    }

    public boolean xoa(String maPL) {
        PhieuLuong phieu = timTheoMa(maPL);
        return phieu != null && danhSach.remove(phieu);
    }

    public long tongLuongPhaiTra(YearMonth thang) {
        long tongLuong = 0;
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getThang().equals(thang)) {
                tongLuong += phieu.tinhThucLinh();
            }
        }
        return tongLuong;
    }

    public void xuat() {
        for (PhieuLuong phieu : danhSach) {
            phieu.xuat();
        }
    }
}
