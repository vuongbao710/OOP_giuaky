
package doangiuaky.KhenThuong;

import java.time.LocalDate;

public abstract class KhenThuongKyLuat {
    private String maQD;
    private LocalDate ngayBanHanh;
    private long soTienTacDong;
    private String maNhanVienRaQD;
    private String maNhanVienNhanQD;
//constructor
    public KhenThuongKyLuat(String maQD, LocalDate ngayBanHanh,
            long soTienTacDong, String maNhanVienRaQD,
            String maNhanVienNhanQD) {

        this.maQD = maQD;
        this.ngayBanHanh = ngayBanHanh;
  if (soTienTacDong < 0) {
    throw new IllegalArgumentException(
        "So tien tac dong khong duoc am!"
    );
}

this.soTienTacDong = soTienTacDong;
        this.maNhanVienRaQD = maNhanVienRaQD;
        this.maNhanVienNhanQD = maNhanVienNhanQD;
    }

    public String getMaQD() {
        return maQD;
    }

    public void setMaQD(String maQD) {
        this.maQD = maQD;
    }

    public LocalDate getNgayBanHanh() {
        return ngayBanHanh;
    }

    public void setNgayBanHanh(LocalDate ngayBanHanh) {
        this.ngayBanHanh = ngayBanHanh;
    }

    public long getSoTienTacDong() {
        return soTienTacDong;
    }

    public void setSoTienTacDong(long soTienTacDong) {
        if (soTienTacDong < 0) {
            throw new IllegalArgumentException(
                "So tien tac dong khong duoc am!"
            );
        }

        this.soTienTacDong = soTienTacDong;
    }

    public String getMaNhanVienRaQD() {
        return maNhanVienRaQD;
    }

    public void setMaNhanVienRaQD(String maNhanVienRaQD) {
        this.maNhanVienRaQD = maNhanVienRaQD;
    }

    public String getMaNhanVienNhanQD() {
        return maNhanVienNhanQD;
    }

    public void setMaNhanVienNhanQD(String maNhanVienNhanQD) {
        this.maNhanVienNhanQD = maNhanVienNhanQD;
    }

    // Lop con bat buoc phai ghi de phuong thuc nay
    public abstract long tinhTacDongLuong();

    @Override
    public String toString() {
        return "Ma quyet dinh: " + maQD
                + "\nNgay ban hanh: " + ngayBanHanh
                + "\nSo tien tac dong: " + soTienTacDong
                + "\nMa nhan vien ra quyet dinh: " + maNhanVienRaQD
                + "\nMa nhan vien nhan quyet dinh: " + maNhanVienNhanQD;
    }
}
