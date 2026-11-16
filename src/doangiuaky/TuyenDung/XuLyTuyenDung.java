package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Enum.ViTri;
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

    // Chuyển 1 ứng viên thành Nhân viên (có cập nhật vào DanhSachPhongBan)
    public static NhanVien chuyenThanhNhanVien(
            UngVien uv,
            DanhSachDotTuyenDung dsDot,
            DanhSachNhanVien dsnv,
            DanhSachPhongBan dspb) {
        if (uv == null) return null;

        String maPhongBan = "PB01";
        String maQuanLy = "QL01";
        boolean isFullTime = true;

        DotTuyenDung dot = dsDot.timKiem(uv.getMaDotTuyenDung());
        if (dot != null) {
            if (dot.getMaNguoiDuyet() != null) {
                maQuanLy = dot.getMaNguoiDuyet();
            }
            ViTriTuyenDung vtTuyen = dot.timViTri(uv.getMaViTriUngTuyen());
            if (vtTuyen != null && vtTuyen.getMaPhongBan() != null) {
                maPhongBan = vtTuyen.getMaPhongBan();
            }
        }

        // Nếu có DanhSachPhongBan, lấy MaTruongPhong làm người quản lý trực tiếp
        PhongBan pb = (dspb != null) ? dspb.timPhongBan(maPhongBan) : null;
        if (pb != null && pb.getMaTruongPhong() != null) {
            maQuanLy = pb.getMaTruongPhong();
        }

        ViTri viTriEnum = ViTri.NhanDien(uv.getMaViTriUngTuyen());
        if (viTriEnum != null) {
            isFullTime = viTriEnum.isFullTime();
        }

        NhanVien nvMoi = chuyenThanhNhanVien(uv, maPhongBan, maQuanLy, isFullTime, dsnv);

        // Thêm nhân viên mới vào danh sách nhân viên của Phòng ban tương ứng
        if (nvMoi != null && pb != null) {
            pb.getdanhsachnhanvien().add(nvMoi);
        }

        return nvMoi;
    }

    // Chuyển 1 ứng viên thành Nhân viên (không cần DanhSachPhongBan)
    public static NhanVien chuyenThanhNhanVien(UngVien uv, DanhSachDotTuyenDung dsDot, DanhSachNhanVien dsnv) {
        return chuyenThanhNhanVien(uv, dsDot, dsnv, null);
    }

    // Chuyển 1 ứng viên thành Nhân viên (truyền tường minh)
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

    // Chuyển toàn bộ ứng viên đạt đào tạo (kèm cập nhật vào Phòng ban)
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

    // Bản giữ tương thích khi không truyền DanhSachPhongBan
    public static ArrayList<NhanVien> chuyenTatCaUngVienDat(
            DanhSachUngVien dsuv,
            DanhSachKetQuaDaoTao dskq,
            DanhSachDotTuyenDung dsDot,
            DanhSachNhanVien dsnv) {
        return chuyenTatCaUngVienDat(dsuv, dskq, dsDot, dsnv, null);
    }
}
