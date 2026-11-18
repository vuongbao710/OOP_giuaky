package doangiuaky.ChamCong;

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
    private final LocalTime gioBatDauCa;
    private final LocalTime gioKetThucCa;
    private final TrangThai trangThai;
    private LocalTime gioVao;
    private LocalTime gioRa;

    public ChiTietChamCong(String maNhanVien, LocalDate ngay,
            LocalTime gioBatDauCa, LocalTime gioKetThucCa) {
        this(maNhanVien, ngay, gioBatDauCa, gioKetThucCa, TrangThai.DI_LAM);
    }

    public ChiTietChamCong(String maNhanVien, LocalDate ngay, TrangThai trangThai) {
        this(maNhanVien, ngay, null, null, trangThai);
    }

    private ChiTietChamCong(String maNhanVien, LocalDate ngay,
            LocalTime gioBatDauCa, LocalTime gioKetThucCa, TrangThai trangThai) {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma nhan vien khong duoc rong");
        }
        if (ngay == null || trangThai == null) {
            throw new IllegalArgumentException("Ngay va trang thai khong duoc null");
        }
        if ((gioBatDauCa == null) != (gioKetThucCa == null)) {
            throw new IllegalArgumentException("Ca lam phai co gio bat dau va gio ket thuc");
        }
        if (gioBatDauCa != null && gioBatDauCa.equals(gioKetThucCa)) {
            throw new IllegalArgumentException("Gio bat dau va gio ket thuc ca khong duoc trung nhau");
        }
        if (trangThai == TrangThai.DI_LAM && gioBatDauCa == null) {
            throw new IllegalArgumentException("Nhan vien di lam phai co gio ca");
        }

        this.maNhanVien = maNhanVien.trim();
        this.ngay = ngay;
        this.gioBatDauCa = gioBatDauCa;
        this.gioKetThucCa = gioKetThucCa;
        this.trangThai = trangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public LocalTime getGioBatDauCa() {
        return gioBatDauCa;
    }

    public LocalTime getGioKetThucCa() {
        return gioKetThucCa;
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

    public void chamCongVao(LocalTime thoiDiem) {
        if (!kiemTraTrongCa(thoiDiem)) {
            throw new IllegalArgumentException("Thoi diem cham cong khong nam trong ca");
        }
        if (gioVao != null) {
            throw new IllegalStateException("Nhan vien da cham cong vao");
        }
        if (gioRa != null) {
            throw new IllegalStateException("Khong the cham cong vao sau khi da cham cong ra");
        }
        gioVao = thoiDiem;
    }

    public void chamCongVao() {
        chamCongVao(LocalTime.now());
    }

    public void chamCongRa(LocalTime thoiDiem) {
        if (!kiemTraTrongCa(thoiDiem)) {
            throw new IllegalArgumentException("Thoi diem cham cong khong nam trong ca");
        }
        if (gioVao == null) {
            throw new IllegalStateException("Nhan vien phai cham cong vao truoc");
        }
        if (gioRa != null) {
            throw new IllegalStateException("Nhan vien da cham cong ra");
        }
        if (soPhutGiua(gioVao, thoiDiem) <= 0) {
            throw new IllegalArgumentException("Gio ra phai sau gio vao");
        }
        gioRa = thoiDiem;
    }

    public void chamCongRa() {
        chamCongRa(LocalTime.now());
    }

    public boolean kiemTraTrongCa(LocalTime thoiDiem) {
        if (thoiDiem == null) {
            throw new IllegalArgumentException("Thoi diem cham cong khong duoc null");
        }
        if (gioBatDauCa == null || gioKetThucCa == null) {
            throw new IllegalStateException("Chi tiet cham cong chua co gio ca");
        }

        int batDau = gioBatDauCa.getHour() * 60 + gioBatDauCa.getMinute();
        int ketThuc = gioKetThucCa.getHour() * 60 + gioKetThucCa.getMinute();
        int thoiGian = thoiDiem.getHour() * 60 + thoiDiem.getMinute();
        if (ketThuc < batDau) {
            ketThuc += 24 * 60;
        }
        if (thoiGian < batDau) {
            thoiGian += 24 * 60;
        }
        return thoiGian >= batDau && thoiGian <= ketThuc;
    }

    public boolean laCaQuaNuaDem() {
        return gioBatDauCa != null && gioKetThucCa.isBefore(gioBatDauCa);
    }

    public long getSoPhutTre() {
        if (gioVao == null || gioBatDauCa == null) {
            return 0;
        }
        int batDau = gioBatDauCa.getHour() * 60 + gioBatDauCa.getMinute();
        int gioVaoTrongNgay = gioVao.getHour() * 60 + gioVao.getMinute();
        if (gioVaoTrongNgay < batDau && laCaQuaNuaDem()) {
            gioVaoTrongNgay += 24 * 60;
        }
        return Math.max(0, gioVaoTrongNgay - batDau);
    }

    public double getSoGioLam() {
        if (gioVao == null || gioRa == null) {
            return 0;
        }
        return soPhutGiua(gioVao, gioRa) / 60.0;
    }

    private int soPhutGiua(LocalTime gioDau, LocalTime gioSau) {
        int dau = gioDau.getHour() * 60 + gioDau.getMinute();
        int sau = gioSau.getHour() * 60 + gioSau.getMinute();
        if (sau < dau) {
            sau += 24 * 60;
        }
        return sau - dau;
    }

    @Override
    public String toString() {
        return "Ma NV: " + maNhanVien + ", Ngay: " + ngay
                + ", Gio vao: " + gioVao + ", Gio ra: " + gioRa
                + ", Tre: " + getSoPhutTre() + " phut, Trang thai: " + trangThai;
    }
}
