package doangiuaky.ChamCong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachChamCong {
    private final ArrayList<ChiTietChamCong> danhSach;

    public DanhSachChamCong() {
        danhSach = new ArrayList<>();
    }

    public void them(ChiTietChamCong chiTiet) {
        if (chiTiet == null) {
            throw new IllegalArgumentException("Chi tiet cham cong khong duoc null");
        }
        if (tim(chiTiet.getMaNhanVien(), chiTiet.getNgay()) != null) {
            throw new IllegalArgumentException("Nhan vien da co cham cong trong ngay nay");
        }
        danhSach.add(chiTiet);
    }

    public ChiTietChamCong tim(String maNhanVien, LocalDate ngay) {
        for (ChiTietChamCong chiTiet : danhSach) {
            if (chiTiet.getMaNhanVien().equalsIgnoreCase(maNhanVien)
                    && chiTiet.getNgay().equals(ngay)) {
                return chiTiet;
            }
        }
        return null;
    }

    public List<ChiTietChamCong> theoNhanVien(String maNhanVien) {
        ArrayList<ChiTietChamCong> ketQua = new ArrayList<>();
        for (ChiTietChamCong chiTiet : danhSach) {
            if (chiTiet.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                ketQua.add(chiTiet);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public long soNgayDiLam(String maNhanVien) {
        return theoNhanVien(maNhanVien).stream()
                .filter(c -> c.getTrangThai() == ChiTietChamCong.TrangThai.DI_LAM)
                .count();
    }

    public double tongSoGioLam(String maNhanVien) {
        return theoNhanVien(maNhanVien).stream()
                .mapToDouble(ChiTietChamCong::getSoGioLam)
                .sum();
    }

    public List<ChiTietChamCong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public void xuat() {
        for (ChiTietChamCong chiTiet : danhSach) {
            System.out.println(chiTiet);
        }
    }

    public void xuatBaoCao(String maNhanVien) {
        System.out.println("Ma NV: " + maNhanVien
                + ", So ngay di lam: " + soNgayDiLam(maNhanVien)
                + ", Tong so gio: " + String.format("%.2f", tongSoGioLam(maNhanVien)));
    }
}
