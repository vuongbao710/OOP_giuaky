package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void themNhieu(List<PhieuLuong> cacPhieu) {
        for (PhieuLuong phieu : cacPhieu) {
            if (phieu == null || tim(phieu.getNhanVien().getMaNV(), phieu.getThang()) != null) {
                throw new IllegalArgumentException("Phieu luong da ton tai");
            }
            danhSach.add(phieu);
        }
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

    public PhieuLuong timTheoMa(String maPL) {
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaPL().equalsIgnoreCase(maPL)) {
                return phieu;
            }
        }
        return null;
    }

    public List<PhieuLuong> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<PhieuLuong> ketQua = new ArrayList<>();
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaPL().toLowerCase().contains(khoa)
                    || phieu.getNhanVien().getMaNV().toLowerCase().contains(khoa)
                    || phieu.getNhanVien().getHoTen().toLowerCase().contains(khoa)) {
                ketQua.add(phieu);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public boolean xoa(String maPL) {
        return danhSach.removeIf(phieu -> phieu.getMaPL().equalsIgnoreCase(maPL));
    }

    public long tongLuongPhaiTra(YearMonth thang) {
        return danhSach.stream()
                .filter(phieu -> phieu.getThang().equals(thang))
                .mapToLong(PhieuLuong::tinhThucLinh)
                .sum();
    }

    public boolean sua(String maPL, DanhSachChamCong chamCong,
            long phuCap, long khauTru) {
        PhieuLuong cu = timTheoMa(maPL);
        if (cu == null) return false;
        PhieuLuong moi = new PhieuLuong(cu.getNhanVien(), cu.getThang(),
                chamCong, phuCap, khauTru);
        danhSach.set(danhSach.indexOf(cu), moi);
        return true;
    }

    public void ghiFile(Path tep) throws IOException {
        ArrayList<String> dong = new ArrayList<>();
        for (PhieuLuong phieu : danhSach) {
            dong.add(phieu.getMaPL() + "," + phieu.getNhanVien().getMaNV()
                    + "," + phieu.getThang() + "," + phieu.tinhThucLinh());
        }
        Files.write(tep, dong);
    }

    public void xuat() {
        for (PhieuLuong phieuLuong : danhSach) {
            phieuLuong.xuat();
        }
    }
}
