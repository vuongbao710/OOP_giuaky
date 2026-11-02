package doangiuaky.PhieuLuong;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachPhieuLuongLinhHoat {
    private final ArrayList<PhieuLuong> danhSach = new ArrayList<>();

    public void them(PhieuLuong phieuLuong) {
        if (phieuLuong == null || tim(phieuLuong.getMaPL()) != null) {
            throw new IllegalArgumentException("Ma phieu luong da ton tai");
        }
        danhSach.add(phieuLuong);
    }

    public void themNhieu(List<? extends PhieuLuong> cacPhieu) {
        for (PhieuLuong phieu : cacPhieu) them(phieu);
    }

    public PhieuLuong tim(String maPL) {
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaPL().equalsIgnoreCase(maPL)) return phieu;
        }
        return null;
    }

    public List<PhieuLuong> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<PhieuLuong> ketQua = new ArrayList<>();
        for (PhieuLuong phieu : danhSach) {
            if (phieu.getMaPL().toLowerCase().contains(khoa)
                    || phieu.getMaNV().toLowerCase().contains(khoa)) {
                ketQua.add(phieu);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public boolean xoa(String maPL) {
        return danhSach.removeIf(p -> p.getMaPL().equalsIgnoreCase(maPL));
    }

    public long tongLuong(YearMonth thang) {
        return danhSach.stream()
                .filter(p -> p.getThang().equals(thang))
                .mapToLong(PhieuLuong::tinhThucLinh)
                .sum();
    }

    public List<PhieuLuong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public void ghiFile(Path tep) throws IOException {
        ArrayList<String> dong = new ArrayList<>();
        for (PhieuLuong p : danhSach) {
            dong.add(p.getMaPL() + "," + p.getMaNV() + "," + p.getThang()
                    + "," + p.tinhThucLinh());
        }
        Files.write(tep, dong);
    }

    public void xuat() {
        for (PhieuLuong p : danhSach) {
            System.out.printf("%-15s %-12s %-10s %,d%n",
                    p.getMaPL(), p.getMaNV(), p.getThang(), p.tinhThucLinh());
        }
    }
}
