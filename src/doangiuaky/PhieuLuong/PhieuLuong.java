package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.ChiTietChamCong;
import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.util.Objects;

public class PhieuLuong {
    public static final int SO_NGAY_CONG_CHUAN = 26;
    public static final int SO_GIO_CONG_CHUAN_MOI_NGAY = 8;

    private final NhanVien nhanVien;
    private final YearMonth thang;
    private final long luongCoBan;
    private final long phuCap;
    private final long khauTru;
    private final long soNgayDiLam;
    private final double soGioLam;
    private final double soGioTangCa;
    private final long luongTheoNgayCong;
    private final long luongTangCa;
    private final long luongThucNhan;

    public PhieuLuong(NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong danhSachChamCong, long phuCap, long khauTru) {
        this.nhanVien = Objects.requireNonNull(nhanVien, "Nhan vien khong duoc null");
        this.thang = Objects.requireNonNull(thang, "Thang khong duoc null");
        Objects.requireNonNull(danhSachChamCong, "Danh sach cham cong khong duoc null");
        if (phuCap < 0 || khauTru < 0) {
            throw new IllegalArgumentException("Phu cap va khau tru khong duoc am");
        }

        this.luongCoBan = nhanVien.tinhLuongThucTe();
        this.phuCap = phuCap;
        this.khauTru = khauTru;
        this.soNgayDiLam = danhSachChamCong.theoNhanVien(nhanVien.getMaNV()).stream()
                .filter(c -> cungThang(c, thang)
                        && c.getTrangThai() == ChiTietChamCong.TrangThai.DI_LAM)
                .count();
        this.soGioLam = danhSachChamCong.theoNhanVien(nhanVien.getMaNV()).stream()
                .filter(c -> cungThang(c, thang))
                .mapToDouble(ChiTietChamCong::getSoGioLam)
                .sum();
        this.soGioTangCa = danhSachChamCong.theoNhanVien(nhanVien.getMaNV()).stream()
                .filter(c -> cungThang(c, thang)
                        && c.getTrangThai() == ChiTietChamCong.TrangThai.DI_LAM)
                .mapToDouble(c -> Math.max(0,
                        c.getSoGioLam() - SO_GIO_CONG_CHUAN_MOI_NGAY))
                .sum();
        this.luongTheoNgayCong = lamTron(
                luongCoBan * (double) soNgayDiLam / SO_NGAY_CONG_CHUAN);
        double donGiaGio = (double) luongCoBan
                / SO_NGAY_CONG_CHUAN / SO_GIO_CONG_CHUAN_MOI_NGAY;
        this.luongTangCa = lamTron(soGioTangCa * donGiaGio * 1.5);
        this.luongThucNhan = luongTheoNgayCong + luongTangCa + phuCap - khauTru;
    }

    private static boolean cungThang(ChiTietChamCong chiTiet, YearMonth thang) {
        return chiTiet.getNgay().getYear() == thang.getYear()
                && chiTiet.getNgay().getMonthValue() == thang.getMonthValue();
    }

    private static long lamTron(double giaTri) {
        return Math.round(giaTri);
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public YearMonth getThang() {
        return thang;
    }

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public long getPhuCap() {
        return phuCap;
    }

    public long getKhauTru() {
        return khauTru;
    }

    public long getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public double getSoGioLam() {
        return soGioLam;
    }

    public double getSoGioTangCa() {
        return soGioTangCa;
    }

    public long getLuongTheoNgayCong() {
        return luongTheoNgayCong;
    }

    public long getLuongTangCa() {
        return luongTangCa;
    }

    public long getLuongThucNhan() {
        return luongThucNhan;
    }

    public void xuat() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n----- PHIEU LUONG -----"
                + "\nThang: " + thang
                + "\nMa NV: " + nhanVien.getMaNV()
                + "\nHo ten: " + nhanVien.getHoTen()
                + "\nChuc vu: " + nhanVien.getChucVu()
                + "\nLuong co ban: " + String.format("%,d", luongCoBan) + " VND"
                + "\nNgay di lam: " + soNgayDiLam
                + "\nTong gio lam: " + String.format("%.2f", soGioLam)
                + "\nGio tang ca: " + String.format("%.2f", soGioTangCa)
                + "\nLuong theo ngay cong: " + String.format("%,d", luongTheoNgayCong) + " VND"
                + "\nLuong tang ca: " + String.format("%,d", luongTangCa) + " VND"
                + "\nPhu cap: " + String.format("%,d", phuCap) + " VND"
                + "\nKhau tru: " + String.format("%,d", khauTru) + " VND"
                + "\nTHUC NHAN: " + String.format("%,d", luongThucNhan) + " VND"
                + "\n-----------------------";
    }
}
