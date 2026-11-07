package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.ChiTietChamCong;
import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.Objects;

public class PhieuLuong {
    public static final int SO_NGAY_CONG_CHUAN = 26;
    public static final int SO_GIO_CONG_CHUAN_MOI_NGAY = 8;

    private static final int LUONG_CO_BAN = 0;
    private static final int PHU_CAP = 1;
    private static final int KHAU_TRU = 2;
    private static final int LUONG_THEO_NGAY_CONG = 3;
    private static final int LUONG_TANG_CA = 4;
    private static final int LUONG_THUC_NHAN = 5;

    private final NhanVien nhanVien;
    private final YearMonth thang;
    private final LocalDate ngayLap;
    private String maPL;
    private final long[] cacKhoanLuong;
    private final long soNgayDiLam;
    private final double soGioLam;
    private final double soGioTangCa;

    private static String maBatBuoc(String maPL) {
        if (maPL == null || maPL.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma phieu luong khong duoc rong");
        }
        return maPL.trim();
    }

    public PhieuLuong(NhanVien nhanVien, YearMonth thang,
            DanhSachChamCong danhSachChamCong, long phuCap, long khauTru) {
        this(nhanVien, thang.atDay(1), thang, danhSachChamCong, phuCap, khauTru,
                nhanVien.getMaNV() + "-" + thang);
    }

    protected PhieuLuong(String maPL, NhanVien nhanVien, LocalDate ngayLap,
            YearMonth thang, DanhSachChamCong danhSachChamCong,
            long phuCap, long khauTru) {
        this(nhanVien, ngayLap, thang, danhSachChamCong, phuCap, khauTru, maPL);
    }

    private PhieuLuong(NhanVien nhanVien, LocalDate ngayLap, YearMonth thang,
            DanhSachChamCong danhSachChamCong, long phuCap, long khauTru,
            String maPL) {
        this.nhanVien = Objects.requireNonNull(nhanVien, "Nhan vien khong duoc null");
        this.thang = Objects.requireNonNull(thang, "Thang khong duoc null");
        this.ngayLap = Objects.requireNonNull(ngayLap, "Ngay lap khong duoc null");
        this.maPL = maBatBuoc(maPL);
        Objects.requireNonNull(danhSachChamCong, "Danh sach cham cong khong duoc null");
        if (phuCap < 0 || khauTru < 0) {
            throw new IllegalArgumentException("Phu cap va khau tru khong duoc am");
        }

        this.cacKhoanLuong = new long[6];
        cacKhoanLuong[LUONG_CO_BAN] = nhanVien.tinhLuongThucTe();
        cacKhoanLuong[PHU_CAP] = phuCap;
        cacKhoanLuong[KHAU_TRU] = khauTru;
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
        cacKhoanLuong[LUONG_THEO_NGAY_CONG] = lamTron(
                cacKhoanLuong[LUONG_CO_BAN] * (double) soNgayDiLam / SO_NGAY_CONG_CHUAN);
        double donGiaGio = (double) cacKhoanLuong[LUONG_CO_BAN]
                / SO_NGAY_CONG_CHUAN / SO_GIO_CONG_CHUAN_MOI_NGAY;
        cacKhoanLuong[LUONG_TANG_CA] = lamTron(soGioTangCa * donGiaGio * 1.5);
        cacKhoanLuong[LUONG_THUC_NHAN] = cacKhoanLuong[LUONG_THEO_NGAY_CONG]
                + cacKhoanLuong[LUONG_TANG_CA] + cacKhoanLuong[PHU_CAP]
                - cacKhoanLuong[KHAU_TRU];
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

    public String getMaPL() {
        return maPL;
    }

    public String getMaNV() {
        return nhanVien.getMaNV();
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public long tinhThucLinh() {
        return getLuongThucNhan();
    }

    public YearMonth getThang() {
        return thang;
    }

    public long getLuongCoBan() {
        return cacKhoanLuong[LUONG_CO_BAN];
    }

    public long getPhuCap() {
        return cacKhoanLuong[PHU_CAP];
    }

    public long getKhauTru() {
        return cacKhoanLuong[KHAU_TRU];
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
        return cacKhoanLuong[LUONG_THEO_NGAY_CONG];
    }

    public long getLuongTangCa() {
        return cacKhoanLuong[LUONG_TANG_CA];
    }

    public long getLuongThucNhan() {
        return cacKhoanLuong[LUONG_THUC_NHAN];
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
                + "\nLuong co ban: " + String.format("%,d", getLuongCoBan()) + " VND"
                + "\nNgay di lam: " + soNgayDiLam
                + "\nTong gio lam: " + String.format("%.2f", soGioLam)
                + "\nGio tang ca: " + String.format("%.2f", soGioTangCa)
                + "\nLuong theo ngay cong: " + String.format("%,d", getLuongTheoNgayCong()) + " VND"
                + "\nLuong tang ca: " + String.format("%,d", getLuongTangCa()) + " VND"
                + "\nPhu cap: " + String.format("%,d", getPhuCap()) + " VND"
                + "\nKhau tru: " + String.format("%,d", getKhauTru()) + " VND"
                + "\nTHUC NHAN: " + String.format("%,d", getLuongThucNhan()) + " VND"
                + "\n-----------------------";
    }
}
