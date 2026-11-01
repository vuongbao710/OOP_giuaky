
package doangiuaky.ChamCong;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class ChiTietChamCong {
    public enum TrangThai {
        DI_LAM,
        NGHI_PHEP,
        NGHI_KHONG_PHEP
    }

    private final String maNhanVien;
    private final LocalDate ngay;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private TrangThai trangThai;

    public ChiTietChamCong(String maNhanVien, LocalDate ngay,
            LocalTime gioVao, LocalTime gioRa, TrangThai trangThai) {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma nhan vien khong duoc rong");
        }
        if (ngay == null || trangThai == null) {
            throw new IllegalArgumentException("Ngay va trang thai khong duoc rong");
        }
        if (trangThai == TrangThai.DI_LAM && (gioVao == null || gioRa == null)) {
            throw new IllegalArgumentException("Nhan vien di lam phai co gio vao va gio ra");
        }
        if (gioVao != null && gioRa != null && !gioRa.isAfter(gioVao)) {
            throw new IllegalArgumentException("Gio ra phai sau gio vao");
        }
        if (trangThai != TrangThai.DI_LAM && (gioVao != null || gioRa != null)) {
            throw new IllegalArgumentException("Ngay nghi khong duoc co gio vao va gio ra");
        }

        this.maNhanVien = maNhanVien.trim();
        this.ngay = ngay;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.trangThai = trangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public LocalTime getGioVao() {
        return gioVao;
    }

    public LocalTime getGioRa() {
        return gioRa;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void capNhatGio(LocalTime gioVao, LocalTime gioRa) {
        if (trangThai != TrangThai.DI_LAM) {
            throw new IllegalStateException("Chi cap nhat gio cho ngay di lam");
        }
        if (gioVao == null || gioRa == null || !gioRa.isAfter(gioVao)) {
            throw new IllegalArgumentException("Gio ra phai sau gio vao");
        }
        this.gioVao = gioVao;
        this.gioRa = gioRa;
    }

    public double getSoGioLam() {
        if (trangThai != TrangThai.DI_LAM) {
            return 0;
        }
        return Duration.between(gioVao, gioRa).toMinutes() / 60.0;
    }

    @Override
    public String toString() {
        String gio = trangThai == TrangThai.DI_LAM
                ? gioVao + " - " + gioRa + " (" + String.format("%.2f", getSoGioLam()) + " gio)"
                : "--";
        return "Ma NV: " + maNhanVien + ", Ngay: " + ngay
                + ", Gio: " + gio + ", Trang thai: " + trangThai;
    }
}
