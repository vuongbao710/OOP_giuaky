package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;

public class KhoaDaoTao {
    private String MaKhoaHoc;
    private String TenKhoaHoc;
    private LocalDate NgayBatDau;
    private LocalDate NgayKetThuc;

    public KhoaDaoTao() {
    }

    public KhoaDaoTao(String MaKhoaHoc, String TenKhoaHoc, LocalDate NgayBatDau, LocalDate NgayKetThuc) {
        this.MaKhoaHoc = MaKhoaHoc;
        this.TenKhoaHoc = TenKhoaHoc;
        this.NgayBatDau = NgayBatDau;
        setNgayKetThuc(NgayKetThuc);
    }

    public String getMaKhoaHoc() {
        return MaKhoaHoc;
    }

    public void setMaKhoaHoc(String MaKhoaHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
    }

    public String getTenKhoaHoc() {
        return TenKhoaHoc;
    }

    public void setTenKhoaHoc(String TenKhoaHoc) {
        this.TenKhoaHoc = TenKhoaHoc;
    }

    public LocalDate getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(LocalDate NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(LocalDate NgayKetThuc) {
        if (NgayBatDau != null && NgayKetThuc != null && NgayKetThuc.isBefore(NgayBatDau)) {
            throw new IllegalArgumentException("Ngay ket thuc khong duoc truoc ngay bat dau!");
        }
        this.NgayKetThuc = NgayKetThuc;
    }

    @Override
    public String toString() {
        return "Ma khoa hoc: " + MaKhoaHoc +
               ", Ten khoa hoc: " + TenKhoaHoc +
               ", Ngay bat dau: " + NgayBatDau +
               ", Ngay ket thuc: " + NgayKetThuc;
    }
}
