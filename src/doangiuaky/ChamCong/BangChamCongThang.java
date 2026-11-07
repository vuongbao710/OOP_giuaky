package doangiuaky.ChamCong;

import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

/**
 * Bang cham cong cua mot thang, luu tru bang mang co dinh.
 */
public class BangChamCongThang extends BangChamCong {
    private final String maBang;
    private final String maNV;
    private final YearMonth thangNam;

    public BangChamCongThang(String maCC, String maNV, YearMonth thangNam) {
        this(maCC, maNV, thangNam, SUC_CHUA_MAC_DINH);
    }

    public BangChamCongThang(String maCC, String maNV, YearMonth thangNam, int sucChua) {
        super(sucChua);
        maBang = batBuoc(maCC, "Ma bang cham cong");
        this.maNV = batBuoc(maNV, "Ma nhan vien");
        this.thangNam = Objects.requireNonNull(thangNam, "Thang nam khong duoc null");
    }

    public String getMaBang() {
        return maBang;
    }

    public String getMaNV() {
        return maNV;
    }

    public YearMonth getThangNam() {
        return thangNam;
    }

    @Override
    public void them(ChamCong chamCong) {
        kiemTraCungThang(chamCong);
        super.them(chamCong);
    }

    public void themNhieu(List<? extends ChamCong> cacChamCong) {
        if (cacChamCong == null) {
            throw new IllegalArgumentException("Danh sach cham cong khong duoc null");
        }
        for (ChamCong chamCong : cacChamCong) {
            them(chamCong);
        }
    }

    @Override
    public boolean sua(String maCC, String maNV, YearMonth thangNam) {
        if (thangNam == null || !this.thangNam.equals(thangNam)) {
            throw new IllegalArgumentException("Cham cong phai thuoc thang cua bang");
        }
        return super.sua(maCC, maNV, thangNam);
    }

    private void kiemTraCungThang(ChamCong chamCong) {
        if (chamCong == null) {
            throw new IllegalArgumentException("Cham cong khong duoc null");
        }
        if (!thangNam.equals(chamCong.getThangNam())) {
            throw new IllegalArgumentException("Cham cong khong thuoc thang cua bang");
        }
    }

    private static String batBuoc(String giaTri, String ten) {
        if (giaTri == null || giaTri.trim().isEmpty()) {
            throw new IllegalArgumentException(ten + " khong duoc rong");
        }
        return giaTri.trim();
    }
}
