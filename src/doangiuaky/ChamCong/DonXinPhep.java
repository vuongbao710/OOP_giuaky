package doangiuaky.ChamCong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DonXinPhep {
    public static final int SUC_CHUA_MAC_DINH = 100;

    public enum TrangThai {
        CHO_DUYET,
        DA_DUYET,
        TU_CHOI
    }

    private static final DonXinPhep[] danhSach = new DonXinPhep[SUC_CHUA_MAC_DINH];
    private static int soLuong;

    private final String maDon;
    private final String maNV;
    private LocalDate tuNgay;
    private LocalDate denNgay;
    private String lyDo;
    private TrangThai trangThai;

    public DonXinPhep(String maDon, String maNV, LocalDate tuNgay,
            LocalDate denNgay, String lyDo) {
        this(maDon, maNV, tuNgay, denNgay, lyDo, TrangThai.CHO_DUYET);
    }

    public DonXinPhep(String maDon, String maNV, LocalDate tuNgay,
            LocalDate denNgay, String lyDo, TrangThai trangThai) {
        this.maDon = batBuoc(maDon, "Ma don");
        this.maNV = batBuoc(maNV, "Ma nhan vien");
        capNhatThoiGian(tuNgay, denNgay);
        this.lyDo = batBuoc(lyDo, "Ly do");
        this.trangThai = Objects.requireNonNull(trangThai, "Trang thai khong duoc null");
    }

    private static String batBuoc(String giaTri, String ten) {
        if (giaTri == null || giaTri.trim().isEmpty()) {
            throw new IllegalArgumentException(ten + " khong duoc rong");
        }
        return giaTri.trim();
    }

    private void capNhatThoiGian(LocalDate tuNgay, LocalDate denNgay) {
        this.tuNgay = Objects.requireNonNull(tuNgay, "Tu ngay khong duoc null");
        this.denNgay = Objects.requireNonNull(denNgay, "Den ngay khong duoc null");
        if (denNgay.isBefore(tuNgay)) {
            throw new IllegalArgumentException("Den ngay phai sau hoac bang tu ngay");
        }
    }

    public String getMaDon() { return maDon; }
    public String getMaNV() { return maNV; }
    public LocalDate getTuNgay() { return tuNgay; }
    public LocalDate getDenNgay() { return denNgay; }
    public String getLyDo() { return lyDo; }
    public TrangThai getTrangThai() { return trangThai; }

    public void sua(LocalDate tuNgay, LocalDate denNgay, String lyDo) {
        capNhatThoiGian(tuNgay, denNgay);
        this.lyDo = batBuoc(lyDo, "Ly do");
    }

    public void capNhatTrangThai(TrangThai trangThai) {
        this.trangThai = Objects.requireNonNull(trangThai, "Trang thai khong duoc null");
    }

    public static void them(DonXinPhep don) {
        if (don == null) {
            throw new IllegalArgumentException("Don xin phep khong duoc null");
        }
        if (timChinhXac(don.maDon) != null) {
            throw new IllegalArgumentException("Da ton tai ma don xin phep");
        }
        if (soLuong == danhSach.length) {
            throw new IllegalStateException("Danh sach don xin phep da day");
        }
        danhSach[soLuong++] = don;
    }

    public static boolean xoa(String maDon) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].maDon.equalsIgnoreCase(maDon)) {
                int soPhanTuCanDich = soLuong - i - 1;
                if (soPhanTuCanDich > 0) {
                    System.arraycopy(danhSach, i + 1, danhSach, i, soPhanTuCanDich);
                }
                danhSach[--soLuong] = null;
                return true;
            }
        }
        return false;
    }

    public static DonXinPhep timChinhXac(String maDon) {
        if (maDon == null) {
            return null;
        }
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].maDon.equalsIgnoreCase(maDon)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public static List<DonXinPhep> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<DonXinPhep> ketQua = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            DonXinPhep don = danhSach[i];
            if (don.maDon.toLowerCase().contains(khoa)
                    || don.maNV.toLowerCase().contains(khoa)
                    || don.lyDo.toLowerCase().contains(khoa)) {
                ketQua.add(don);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public static List<DonXinPhep> getDanhSach() {
        ArrayList<DonXinPhep> ketQua = new ArrayList<>(soLuong);
        for (int i = 0; i < soLuong; i++) {
            ketQua.add(danhSach[i]);
        }
        return Collections.unmodifiableList(ketQua);
    }

    public static int getSoLuong() {
        return soLuong;
    }

    public static int getSucChua() {
        return danhSach.length;
    }

    public static void xoaTatCa() {
        for (int i = 0; i < soLuong; i++) {
            danhSach[i] = null;
        }
        soLuong = 0;
    }
}
