package doangiuaky.PhieuLuong;

import doangiuaky.ChamCong.ChiTietChamCong;
import doangiuaky.ChamCong.DanhSachChamCong;
import doangiuaky.nhanSu.NhanVien;
import java.time.LocalDate;
import java.time.YearMonth;

public class PhieuLuong {
    public static final int SO_NGAY_CONG_CHUAN = 26;
    public static final int SO_GIO_CONG_CHUAN_MOI_NGAY = 8;

    private static int soThuTuTiepTheo = 1;

    private final String maPL;
    private final NhanVien nhanVien;
    private final YearMonth thang;
    private final LocalDate ngayLap;
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
        if (nhanVien == null || thang == null || danhSachChamCong == null) {
            throw new IllegalArgumentException("Nhan vien, thang va cham cong khong duoc null");
        }
        if (phuCap < 0 || khauTru < 0) {
            throw new IllegalArgumentException("Phu cap va khau tru khong duoc am");
        }

        maPL = "PL-" + thang.toString().replace("-", "")
                + "-" + String.format("%04d", soThuTuTiepTheo++);
        this.nhanVien = nhanVien;
        this.thang = thang;
        ngayLap = LocalDate.now();
        this.luongCoBan = nhanVien.tinhLuongThucTe();
        this.phuCap = phuCap;
        this.khauTru = khauTru;

        long ngayCong = 0;
        double gioLam = 0;
        double gioTangCa = 0;
        for (ChiTietChamCong chiTiet
                : danhSachChamCong.theoNhanVien(nhanVien.getMaNV(), thang)) {
            if (chiTiet.getTrangThai() == ChiTietChamCong.TrangThai.DI_LAM
                    && chiTiet.getSoGioLam() > 0) {
                ngayCong++;
                gioLam += chiTiet.getSoGioLam();
                gioTangCa += Math.max(0,
                        chiTiet.getSoGioLam() - SO_GIO_CONG_CHUAN_MOI_NGAY);
            }
        }
        soNgayDiLam = ngayCong;
        soGioLam = gioLam;
        soGioTangCa = gioTangCa;
        luongTheoNgayCong = Math.round(
                this.luongCoBan * (double) soNgayDiLam / SO_NGAY_CONG_CHUAN);
        double donGiaGio = (double) this.luongCoBan
                / SO_NGAY_CONG_CHUAN / SO_GIO_CONG_CHUAN_MOI_NGAY;
        luongTangCa = Math.round(soGioTangCa * donGiaGio * 1.5);
        luongThucNhan = luongTheoNgayCong + luongTangCa + this.phuCap - this.khauTru;
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

    public long tinhThucLinh() {
        return luongThucNhan;
    }

    public void xuat() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n----- PHIEU LUONG -----"
                + "\nMa phieu: " + maPL
                + "\nThang: " + thang
                + "\nMa NV: " + nhanVien.getMaNV()
                + "\nHo ten: " + nhanVien.getHoTen()
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
