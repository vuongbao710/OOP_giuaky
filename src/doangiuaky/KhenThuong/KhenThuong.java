package doangiuaky.KhenThuong;
import doangiuaky.Enum.LoaiKhenThuong;
import doangiuaky.nhanSu.NhanVien;
import java.time.LocalDate;
import java.time.Period;
public class KhenThuong extends KhenThuongKyLuat {

    private LoaiKhenThuong loaiKhenThuong;

    public KhenThuong(String maQD, LocalDate ngayBanHanh,
            long soTienTacDong, String maNhanVienRaQD,
            String maNhanVienNhanQD, LoaiKhenThuong loaiKhenThuong) {

        super(maQD, ngayBanHanh, soTienTacDong,
                maNhanVienRaQD, maNhanVienNhanQD);

        setLoaiKhenThuong(loaiKhenThuong);
    }

    public LoaiKhenThuong getLoaiKhenThuong() {
        return loaiKhenThuong;
    }

    public void setLoaiKhenThuong(LoaiKhenThuong loaiKhenThuong) {

        if (loaiKhenThuong == null) {
            throw new IllegalArgumentException(
                "Loai khen thuong khong duoc null!"
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
        if (loaiKhenThuong == LoaiKhenThuong.THUONG_TET) {

            int thang = getNgayBanHanh().getMonthValue();

            return thang == 11 || thang == 12;
        }

        // Thuong sang kien: luon hop le
        if (loaiKhenThuong == LoaiKhenThuong.THUONG_SANG_KIEN) {
            return true;
        }

        // Thuong tham nien: xet moc 3, 5, 10 nam
        if (loaiKhenThuong == LoaiKhenThuong.THUONG_THAM_NIEN) {

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

            return soNam == 3 || soNam == 5 || soNam == 10;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nLoai khen thuong: " + loaiKhenThuong;
    }
}