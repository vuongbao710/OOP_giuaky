package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;
import java.util.ArrayList;

public class DotTuyenDung {
    public static final String TRANG_THAI_CHO_DUYET = "Cho duyet";
    public static final String TRANG_THAI_DANG_TUYEN = "Dang tuyen";
    public static final String TRANG_THAI_DA_DONG = "Da dong";

    private String MaDotTuyenDung;
    private String MaPhongBan;       // Phòng ban yêu cầu tuyển dụng
    private String MaNguoiDuyet;     // Admin duyệt đợt tuyển dụng
    private ArrayList<ViTri> DsViTri;
    private int SoLuongCanTuyen;
    private LocalDate NgayTuyenDung; // Ngày bắt đầu tuyển
    private LocalDate NgayHetHan;    // Ngày kết thúc/hết hạn đợt tuyển
    private String TrangThai;        // Cho duyet - Dang tuyen - Da dong

    public DotTuyenDung() {
        this.DsViTri = new ArrayList<>();
        this.TrangThai = TRANG_THAI_CHO_DUYET;
    }

    public DotTuyenDung(String MaDotTuyenDung, String MaPhongBan, LocalDate NgayTuyenDung, LocalDate NgayHetHan) {
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.MaPhongBan = MaPhongBan;
        this.NgayTuyenDung = NgayTuyenDung;
        setNgayHetHan(NgayHetHan);
        this.DsViTri = new ArrayList<>();
        this.SoLuongCanTuyen = 0;
        this.TrangThai = TRANG_THAI_CHO_DUYET; // Mới tạo mặc định là Chờ duyệt
    }

    public DotTuyenDung(String MaDotTuyenDung, String MaPhongBan, String MaNguoiDuyet, LocalDate NgayTuyenDung, LocalDate NgayHetHan) {
        this(MaDotTuyenDung, MaPhongBan, NgayTuyenDung, NgayHetHan);
        this.MaNguoiDuyet = MaNguoiDuyet;
    }

    public String getMaDotTuyenDung() {
        return MaDotTuyenDung;
    }

    public void setMaDotTuyenDung(String MaDotTuyenDung) { this.MaDotTuyenDung = MaDotTuyenDung; }

    public String getMaPhongBan() { return MaPhongBan; }

    public void setMaPhongBan(String MaPhongBan) { this.MaPhongBan = MaPhongBan; }

    public String getMaNguoiDuyet() { return MaNguoiDuyet; }

    public void setMaNguoiDuyet(String MaNguoiDuyet) { this.MaNguoiDuyet = MaNguoiDuyet; }

    public ArrayList<ViTri> getDsViTri() { return DsViTri; }

    public void setDsViTri(ArrayList<ViTri> DsViTri) {
        this.DsViTri = (DsViTri != null) ? DsViTri : new ArrayList<>();
        capNhatTongSoLuong();
    }

    public int getSoLuongCanTuyen() { return SoLuongCanTuyen; }

    public void setSoLuongCanTuyen(int SoLuongCanTuyen) { this.SoLuongCanTuyen = SoLuongCanTuyen; }

    public LocalDate getNgayTuyenDung() { return NgayTuyenDung; }

    public void setNgayTuyenDung(LocalDate NgayTuyenDung) { this.NgayTuyenDung = NgayTuyenDung; }

    public LocalDate getNgayHetHan() { return NgayHetHan; }

    public void setNgayHetHan(LocalDate NgayHetHan) {
        if (NgayTuyenDung != null && NgayHetHan != null && NgayHetHan.isBefore(NgayTuyenDung)) {
            throw new IllegalArgumentException("Ngay het han khong duoc truoc ngay tuyen dung!");
        }
        this.NgayHetHan = NgayHetHan;
    }

    public String getTrangThai() { return TrangThai; }

    public void setTrangThai(String TrangThai) {
        if (TRANG_THAI_CHO_DUYET.equalsIgnoreCase(TrangThai)) {
            this.TrangThai = TRANG_THAI_CHO_DUYET;
        } else if (TRANG_THAI_DANG_TUYEN.equalsIgnoreCase(TrangThai)) {
            this.TrangThai = TRANG_THAI_DANG_TUYEN;
        } else if (TRANG_THAI_DA_DONG.equalsIgnoreCase(TrangThai)) {
            this.TrangThai = TRANG_THAI_DA_DONG;
        } else {
            throw new IllegalArgumentException("Trang thai chi bao gom: Cho duyet, Dang tuyen, Da dong!");
        }
    }

    // Thêm vị trí kèm số lượng & tự động cộng dồn tổng số lượng cần tuyển của đợt
    public void themViTri(ViTri vt) {
        if (vt != null && timViTri(vt.getMaViTri()) == null) {
            this.DsViTri.add(vt);
            capNhatTongSoLuong();
        }
    }

    private void capNhatTongSoLuong() {
        int tong = 0;
        for (ViTri vt : DsViTri) {
            tong += vt.getSoLuong();
        }
        this.SoLuongCanTuyen = tong;
    }

    public ViTri timViTri(String maViTri) {
        for (ViTri vt : DsViTri) {
            if (vt.getMaViTri().equalsIgnoreCase(maViTri)) {
                return vt;
            }
        }
        return null;
    }

    public boolean kiemTraViTri(String maViTri) {
        return timViTri(maViTri) != null;
    }

    @Override
    public String toString() {
        return "Ma dot tuyen dung: " + MaDotTuyenDung +
               ", Ma phong ban: " + MaPhongBan +
               ", Ma nguoi duyet: " + MaNguoiDuyet +
               ", Ngay tuyen dung: " + NgayTuyenDung +
               ", Ngay het han: " + NgayHetHan +
               ", Trang thai: " + TrangThai +
               ", Tong so luong can tuyen: " + SoLuongCanTuyen +
               ", Danh sach vi tri: " + DsViTri;
    }
}
