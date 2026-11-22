package doangiuaky.tuyenDungDaoTao;

import doangiuaky.nhanSu.DanhSachNhanVien;
import doangiuaky.nhanSu.DanhSachPhongBan;
import doangiuaky.nhanSu.NhanVien;
import doangiuaky.nhanSu.NhanVienFullTime;
import doangiuaky.nhanSu.NhanVienPartTime;
import doangiuaky.nhanSu.PhongBan;
import java.time.LocalDate;
import java.util.ArrayList;

public class XuLyTuyenDung {
    private static int autoIncrementNV = 3; // Tiếp nối NV01, NV02 của dữ liệu mẫu

    // =========================================================================
    // 1. QUẢN LÝ VÒNG ĐỜI ĐỢT TUYỂN DỤNG (ĐĂNG TẢI - DUYỆT - KIỂM TRA HẾT HẠN)
    // =========================================================================

    /**
     * Quản lý phòng ban đăng tải đợt tuyển dụng mới lên hệ thống.
     * Trạng thái ban đầu mặc định là "Cho duyet" để chờ Admin xem xét.
     */
    public static boolean DangTaiDotTuyenDung(DotTuyenDung dotMoi, DanhSachDotTuyenDung dsDot) {
        if (dotMoi == null || dsDot == null) return false;
        if (dsDot.timKiem(dotMoi.getMaDotTuyenDung()) != null) {
            return false; // Trùng mã đợt tuyển dụng
        }
        dotMoi.setTrangThai(DotTuyenDung.TRANG_THAI_CHO_DUYET);
        dsDot.them(dotMoi);
        return true;
    }

    /**
     * Admin xem xét và duyệt đợt tuyển dụng -> chuyển trạng thái sang "Dang tuyen".
     */
    public static boolean DuyetDotTuyenDung(String maDot, String maAdminDuyet, DanhSachDotTuyenDung dsDot) {
        if (dsDot == null) return false;
        DotTuyenDung dot = dsDot.timKiem(maDot);
        if (dot == null) return false;

        // Chỉ duyệt được các đợt đang ở trạng thái "Cho duyet"
        if (!DotTuyenDung.TRANG_THAI_CHO_DUYET.equalsIgnoreCase(dot.getTrangThai())) {
            return false;
        }

        // Nếu đợt đã quá hạn trước khi kịp duyệt thì đóng luôn
        if (dot.getNgayHetHan() != null && LocalDate.now().isAfter(dot.getNgayHetHan())) {
            dot.setTrangThai(DotTuyenDung.TRANG_THAI_DA_DONG);
            return false;
        }

        dot.setMaNguoiDuyet(maAdminDuyet);
        dot.setTrangThai(DotTuyenDung.TRANG_THAI_DANG_TUYEN);
        return true;
    }

    /**
     * Kiểm tra 1 đợt tuyển dụng: nếu đã tới hoặc vượt qua ngày hết hạn thì set TrangThai = "Da dong".
     * @return true nếu đợt đã bị đóng do hết hạn, false nếu chưa hết hạn
     */
    public static boolean kiemTraHetHan(DotTuyenDung dot) {
        if (dot == null || dot.getNgayHetHan() == null) return false;

        // Nếu ngày hiện tại >= ngày hết hạn (hoặc sau ngày hết hạn) thì đóng đợt tuyển
        if (!LocalDate.now().isBefore(dot.getNgayHetHan())) {
            dot.setTrangThai(DotTuyenDung.TRANG_THAI_DA_DONG);
            return true;
        }
        return false;
    }

    /**
     * Quét toàn bộ danh sách đợt tuyển dụng để tự động đóng các đợt đã tới ngày hết hạn.
     */
    public static void kiemTraHetHanTatCa(DanhSachDotTuyenDung dsDot) {
        if (dsDot == null) return;
        for (DotTuyenDung dot : dsDot.layTatCa()) {
            kiemTraHetHan(dot);
        }
    }

    // =========================================================================
    // 2. CHUYỂN ĐỔI ỨNG VIÊN ĐẠT ĐÀO TẠO THÀNH NHÂN VIÊN (FULL-TIME / PART-TIME)
    // =========================================================================

    public static NhanVien chuyenThanhNhanVien(
            UngVien uv,
            DanhSachDotTuyenDung dsDot,
            DanhSachNhanVien dsnv,
            DanhSachPhongBan dspb) {
        if (uv == null) return null;

        String maPhongBan = "PB01";
        String maQuanLy = "QL01";

        DotTuyenDung dot = (dsDot != null) ? dsDot.timKiem(uv.getMaDotTuyenDung()) : null;
        if (dot != null) {
            if (dot.getMaPhongBan() != null) {
                maPhongBan = dot.getMaPhongBan();
            }
            if (dot.getMaNguoiDuyet() != null) {
                maQuanLy = dot.getMaNguoiDuyet();
            }
        }

        // Lấy Trưởng phòng làm người quản lý trực tiếp nếu có DanhSachPhongBan
        PhongBan pb = (dspb != null) ? dspb.timPhongBan(maPhongBan) : null;
        if (pb != null && pb.getMaTruongPhong() != null) {
            maQuanLy = pb.getMaTruongPhong();
        }

        // Xác định Full time hay Part time dựa trực tiếp trên thuộc tính HinhThucLamViec của UngVien
        boolean isFullTime = UngVien.HINH_THUC_FULL_TIME.equalsIgnoreCase(uv.getHinhThucLamViec());

        NhanVien nvMoi = chuyenThanhNhanVien(uv, maPhongBan, maQuanLy, isFullTime, dsnv);

        if (nvMoi != null && pb != null) {
            pb.getdanhsachnhanvien().add(nvMoi);
        }

        return nvMoi;
    }

    public static NhanVien chuyenThanhNhanVien(UngVien uv, DanhSachDotTuyenDung dsDot, DanhSachNhanVien dsnv) {
        return chuyenThanhNhanVien(uv, dsDot, dsnv, null);
    }

    public static NhanVien chuyenThanhNhanVien(
            UngVien uv,
            String MaPhongBan,
            String MaQuanLyPhuTrach,
            boolean isFullTime,
            DanhSachNhanVien dsnv) {
        if (uv == null) return null;

        String maNVMoi = String.format("NV%02d", autoIncrementNV++);
        NhanVien nvMoi;

        // Khớp thứ tự tham số constructor của NhanVienFullTime / NhanVienPartTime (MaQuanLyPhuTrach trước MaPhongBan)
        if (isFullTime) {
            nvMoi = new NhanVienFullTime(
                maNVMoi,
                uv.getCCCD(),
                uv.getHoTen(),
                uv.getSDT(),
                MaQuanLyPhuTrach,
                MaPhongBan,
                uv.getNgayThangNamSinh(),
                LocalDate.now(),
                "nhân viên"
            );
        } else {
            nvMoi = new NhanVienPartTime(
                maNVMoi,
                uv.getCCCD(),
                uv.getHoTen(),
                uv.getSDT(),
                MaQuanLyPhuTrach,
                MaPhongBan,
                uv.getNgayThangNamSinh(),
                LocalDate.now(),
                "thời vụ"
            );
        }

        dsnv.themNhanVien(nvMoi);
        return nvMoi;
    }

    public static ArrayList<NhanVien> chuyenTatCaUngVienDat(
            DanhSachUngVien dsuv,
            DanhSachKetQuaDaoTao dskq,
            DanhSachDotTuyenDung dsDot,
            DanhSachNhanVien dsnv,
            DanhSachPhongBan dspb) {

        ArrayList<NhanVien> dsNVMoi = new ArrayList<>();
        ArrayList<String> dsMaUVDat = dskq.layUngVienDat();

        for (String maUV : dsMaUVDat) {
            UngVien uv = dsuv.timKiem(maUV);
            if (uv != null) {
                NhanVien nvMoi = chuyenThanhNhanVien(uv, dsDot, dsnv, dspb);
                if (nvMoi != null) {
                    dsNVMoi.add(nvMoi);
                }
            }
        }
        return dsNVMoi;
    }

    public static ArrayList<NhanVien> chuyenTatCaUngVienDat(
            DanhSachUngVien dsuv,
            DanhSachKetQuaDaoTao dskq,
            DanhSachDotTuyenDung dsDot,
            DanhSachNhanVien dsnv) {
        return chuyenTatCaUngVienDat(dsuv, dskq, dsDot, dsnv, null);
    }
}
