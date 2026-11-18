package doangiuaky.ChamCong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachChamCong {
    private BangChamCong bangChamCongHienTai;
    private final ArrayList<BangChamCong> danhSachBangChamCong;

    public DanhSachChamCong() {
        this(YearMonth.now());
    }

    public DanhSachChamCong(YearMonth thangNam) {
        bangChamCongHienTai = new BangChamCong(thangNam);
        danhSachBangChamCong = new ArrayList<>();
    }

    public BangChamCong getBangChamCongHienTai() {
        return bangChamCongHienTai;
    }

    public List<BangChamCong> getDanhSachBangChamCong() {
        return Collections.unmodifiableList(danhSachBangChamCong);
    }

    public void batDauThangMoi(YearMonth thangMoi) {
        if (thangMoi == null) {
            throw new IllegalArgumentException("Thang moi khong duoc null");
        }
        if (!thangMoi.isAfter(bangChamCongHienTai.getThangNam())) {
            throw new IllegalArgumentException("Thang moi phai sau thang hien tai");
        }
        danhSachBangChamCong.add(bangChamCongHienTai);
        bangChamCongHienTai = new BangChamCong(thangMoi);
    }

    public void them(ChiTietChamCong chiTiet) {
        if (chiTiet == null) {
            throw new IllegalArgumentException("Chi tiet cham cong khong duoc null");
        }
        YearMonth thangChamCong = YearMonth.from(chiTiet.getNgay());
        chuyenThangNeuCan(thangChamCong);
        bangChamCongHienTai.them(chiTiet);
    }

    public ChiTietChamCong chamCongVao(String maNhanVien, LocalDateTime thoiDiem,
            LocalTime gioBatDauCa, LocalTime gioKetThucCa) {
        if (thoiDiem == null) {
            throw new IllegalArgumentException("Thoi diem cham cong khong duoc null");
        }
        chuyenThangNeuCan(YearMonth.from(thoiDiem));
        ChiTietChamCong chiTiet = new ChiTietChamCong(maNhanVien,
                thoiDiem.toLocalDate(), gioBatDauCa, gioKetThucCa);
        chiTiet.chamCongVao(thoiDiem.toLocalTime());
        bangChamCongHienTai.them(chiTiet);
        return chiTiet;
    }

    public ChiTietChamCong chamCongVao(String maNhanVien,
            LocalTime gioBatDauCa, LocalTime gioKetThucCa) {
        return chamCongVao(maNhanVien, LocalDateTime.now(),
                gioBatDauCa, gioKetThucCa);
    }

    public ChiTietChamCong chamCongRa(String maNhanVien, LocalDateTime thoiDiem) {
        if (thoiDiem == null) {
            throw new IllegalArgumentException("Thoi diem cham cong khong duoc null");
        }
        chuyenThangNeuCan(YearMonth.from(thoiDiem));
        ChiTietChamCong chiTiet = tim(maNhanVien, thoiDiem.toLocalDate());
        if (chiTiet == null && !thoiDiem.toLocalDate().equals(LocalDate.MIN)) {
            ChiTietChamCong homTruoc = tim(maNhanVien, thoiDiem.toLocalDate().minusDays(1));
            if (homTruoc != null && homTruoc.laCaQuaNuaDem()) {
                chiTiet = homTruoc;
            }
        }
        if (chiTiet == null) {
            throw new IllegalStateException("Khong tim thay lan cham cong vao cua nhan vien trong ca nay");
        }
        chiTiet.chamCongRa(thoiDiem.toLocalTime());
        return chiTiet;
    }

    public ChiTietChamCong chamCongRa(String maNhanVien) {
        return chamCongRa(maNhanVien, LocalDateTime.now());
    }

    private void chuyenThangNeuCan(YearMonth thang) {
        if (thang.isAfter(bangChamCongHienTai.getThangNam())) {
            batDauThangMoi(thang);
        }
        if (!thang.equals(bangChamCongHienTai.getThangNam())) {
            throw new IllegalArgumentException("Khong the them cham cong vao thang da luu tru");
        }
    }

    public ChiTietChamCong tim(String maNhanVien, LocalDate ngay) {
        if (ngay == null) {
            return null;
        }
        YearMonth thangCanTim = YearMonth.from(ngay);
        if (bangChamCongHienTai.getThangNam().equals(thangCanTim)) {
            return bangChamCongHienTai.tim(maNhanVien, ngay);
        }
        for (BangChamCong bang : danhSachBangChamCong) {
            if (bang.getThangNam().equals(thangCanTim)) {
                return bang.tim(maNhanVien, ngay);
            }
        }
        return null;
    }

    public List<ChiTietChamCong> theoNhanVien(String maNhanVien) {
        ArrayList<ChiTietChamCong> ketQua = new ArrayList<>();
        for (ChiTietChamCong chiTiet : getDanhSach()) {
            if (chiTiet.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                ketQua.add(chiTiet);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public List<ChiTietChamCong> theoNhanVien(String maNhanVien, YearMonth thang) {
        ArrayList<ChiTietChamCong> ketQua = new ArrayList<>();
        for (ChiTietChamCong chiTiet : theoNhanVien(maNhanVien)) {
            if (YearMonth.from(chiTiet.getNgay()).equals(thang)) {
                ketQua.add(chiTiet);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public long soNgayDiLam(String maNhanVien) {
        long soNgay = 0;
        for (ChiTietChamCong chiTiet : theoNhanVien(maNhanVien)) {
            if (chiTiet.getTrangThai() == ChiTietChamCong.TrangThai.DI_LAM
                    && chiTiet.getSoGioLam() > 0) {
                soNgay++;
            }
        }
        return soNgay;
    }

    public double tongSoGioLam(String maNhanVien) {
        double tong = 0;
        for (ChiTietChamCong chiTiet : theoNhanVien(maNhanVien)) {
            tong += chiTiet.getSoGioLam();
        }
        return tong;
    }

    public List<ChiTietChamCong> getDanhSach() {
        ArrayList<ChiTietChamCong> ketQua = new ArrayList<>();
        for (BangChamCong bang : danhSachBangChamCong) {
            ketQua.addAll(bang.getDanhSach());
        }
        ketQua.addAll(bangChamCongHienTai.getDanhSach());
        return Collections.unmodifiableList(ketQua);
    }

    public void xuat() {
        for (ChiTietChamCong chiTiet : getDanhSach()) {
            System.out.println(chiTiet);
        }
    }

    public void xuatBaoCao(String maNhanVien) {
        System.out.println("Ma NV: " + maNhanVien
                + ", So ngay di lam: " + soNgayDiLam(maNhanVien)
                + ", Tong so gio: " + String.format("%.2f", tongSoGioLam(maNhanVien)));
    }
}
