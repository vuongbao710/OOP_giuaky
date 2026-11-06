
package doangiuaky.KhenThuong;

import java.time.LocalDate;

public class KyLuat extends KhenThuongKyLuat {

    public static final String PHAT_VANG_KHONG_PHEP =
            "Phat vang khong phep";

    public static final String PHAT_DI_TRE =
            "Phat di tre";

    private String loaiKyLuat;

    public KyLuat(String maQD, LocalDate ngayBanHanh,
            long soTienTacDong, String maNhanVienRaQD,
            String maNhanVienNhanQD, String loaiKyLuat) {

        super(maQD, ngayBanHanh, soTienTacDong,
                maNhanVienRaQD, maNhanVienNhanQD);

        setLoaiKyLuat(loaiKyLuat);
    }

    public String getLoaiKyLuat() {
        return loaiKyLuat;
    }

    public void setLoaiKyLuat(String loaiKyLuat) {
        if (!PHAT_VANG_KHONG_PHEP.equals(loaiKyLuat)
                && !PHAT_DI_TRE.equals(loaiKyLuat)) {

            throw new IllegalArgumentException(
                "Loai ky luat khong hop le!"
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
