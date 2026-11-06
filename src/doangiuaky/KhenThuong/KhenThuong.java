
package doangiuaky.KhenThuong;
import java.time.LocalDate;
import java.time.Period;
public class KhenThuong extends KhenThuongKyLuat {

    public static final String THUONG_TET = "Thuong tet";
    public static final String THUONG_SANG_KIEN = "Thuong sang kien";
    public static final String THUONG_THAM_NIEN = "Thuong tham nien";

    private String loaiKhenThuong;

    public KhenThuong(String maQD, LocalDate ngayBanHanh,
            long soTienTacDong, String maNhanVienRaQD,
            String maNhanVienNhanQD, String loaiKhenThuong) {

        super(maQD, ngayBanHanh, soTienTacDong,
                maNhanVienRaQD, maNhanVienNhanQD);

        setLoaiKhenThuong(loaiKhenThuong);
    }

    public String getLoaiKhenThuong() {
        return loaiKhenThuong;
    }

    public void setLoaiKhenThuong(String loaiKhenThuong) {
        if (!THUONG_TET.equals(loaiKhenThuong)
                && !THUONG_SANG_KIEN.equals(loaiKhenThuong)
                && !THUONG_THAM_NIEN.equals(loaiKhenThuong)) {

            throw new IllegalArgumentException(
                "Loai khen thuong khong hop le!"
            );
        }

        this.loaiKhenThuong = loaiKhenThuong;
    }

    @Override
    public long tinhTacDongLuong() {
        return getSoTienTacDong();
    }

    public boolean kiemTraHopLe(
            NhanVien nv,
            DanhSachKhenThuongKyLuat ds) {

        if (nv == null) {
            return false;
        }

        if (getNgayBanHanh() == null) {
            return false;
        }

        // Thuong tet: chi hop le trong thang 11 hoac 12
        if (THUONG_TET.equals(loaiKhenThuong)) {
            int thang = getNgayBanHanh().getMonthValue();

            return thang == 11 || thang == 12;
        }

        // Thuong sang kien: luon hop le
        if (THUONG_SANG_KIEN.equals(loaiKhenThuong)) {
            return true;
        }

        // Thuong tham nien: xet moc 3, 5, 10 nam
        if (THUONG_THAM_NIEN.equals(loaiKhenThuong)) {

            LocalDate ngayVaoLam = nv.getNgayVaoLam();

            if (ngayVaoLam == null) {
                return false;
            }

            if (ngayVaoLam.isAfter(getNgayBanHanh())) {
                return false;
            }

            int soNam = Period.between(
                    ngayVaoLam,
                    getNgayBanHanh()
            ).getYears();

            return soNam >= 3 && (soNam == 3
                    || soNam == 5
                    || soNam == 10);
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nLoai khen thuong: " + loaiKhenThuong;
    }
}
