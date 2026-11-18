package doangiuaky.ChamCong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachDonXinPhep {
    private final ArrayList<DonXinPhep> danhSach;

    public DanhSachDonXinPhep() {
        danhSach = new ArrayList<>();
    }

    public void them(DonXinPhep don) {
        if (don == null) {
            throw new IllegalArgumentException("Don xin phep khong duoc null");
        }
        if (timChinhXac(don.getMaDon()) != null) {
            throw new IllegalArgumentException("Da ton tai ma don xin phep");
        }
        danhSach.add(don);
    }

    public boolean xoa(String maDon) {
        DonXinPhep don = timChinhXac(maDon);
        return don != null && danhSach.remove(don);
    }

    public DonXinPhep timChinhXac(String maDon) {
        if (maDon == null) {
            return null;
        }
        for (DonXinPhep don : danhSach) {
            if (don.getMaDon().equalsIgnoreCase(maDon)) {
                return don;
            }
        }
        return null;
    }

    public List<DonXinPhep> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<DonXinPhep> ketQua = new ArrayList<>();
        for (DonXinPhep don : danhSach) {
            if (don.getMaDon().toLowerCase().contains(khoa)
                    || don.getMaNV().toLowerCase().contains(khoa)
                    || don.getLyDo().toLowerCase().contains(khoa)) {
                ketQua.add(don);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public List<DonXinPhep> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    public int getSoLuong() {
        return danhSach.size();
    }
}
