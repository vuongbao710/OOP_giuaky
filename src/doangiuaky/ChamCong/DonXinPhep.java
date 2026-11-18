package doangiuaky.ChamCong;

import java.time.LocalDate;
import java.util.Objects;

public class DonXinPhep {
    public enum TrangThai {
        CHO_DUYET,
        DA_DUYET,
        TU_CHOI
    }

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

}
