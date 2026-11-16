package doangiuaky.KhenThuong;
import doangiuaky.Enum.LoaiKyLuat;
import java.time.LocalDate;
public class KyLuat extends KhenThuongKyLuat {

    private LoaiKyLuat loaiKyLuat;

    public KyLuat(String maQD, LocalDate ngayBanHanh,
            long soTienTacDong, String maNhanVienRaQD,
            String maNhanVienNhanQD, LoaiKyLuat loaiKyLuat) {

        super(maQD, ngayBanHanh, soTienTacDong,
                maNhanVienRaQD, maNhanVienNhanQD);

        setLoaiKyLuat(loaiKyLuat);
    }

    public LoaiKyLuat getLoaiKyLuat() {
        return loaiKyLuat;
    }

    public void setLoaiKyLuat(LoaiKyLuat loaiKyLuat) {

        if (loaiKyLuat == null) {
            throw new IllegalArgumentException(
                "Loai ky luat khong duoc null!"
            );
        }

        this.loaiKyLuat = loaiKyLuat;
    }

    @Override
    public long tinhTacDongLuong() {
        return -getSoTienTacDong();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nLoai ky luat: " + loaiKyLuat;
    }
}
