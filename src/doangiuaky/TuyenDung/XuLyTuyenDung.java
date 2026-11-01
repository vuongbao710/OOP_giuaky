package doangiuaky.tuyenDungDaoTao;

import doangiuaky.nhanSu.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class XuLyTuyenDung {
    private static int autoIncrementNV = 3; // Tiếp nối NV01, NV02 của dữ liệu mẫu

    public static NhanVienCapDuoi chuyenThanhNhanVien(UngVien uv, String MaPhongBan, String MaQuanLy, DanhSachNhanVien dsnv, DanhSachPhongBan dspb) {
        if (uv == null) return null;

        // Sinh mã NV dạng NV03, NV04...
        String maNVMoi = String.format("NV%02d", autoIncrementNV++);
        
        NhanVienCapDuoi nvMoi = new NhanVienCapDuoi(
            maNVMoi,
            uv.getHoTen(),
            uv.getNgaySinh(),
            "Nhan vien",
            uv.getSDT(),
            MaPhongBan,
            LocalDate.now(),
            MaQuanLy
        );

        // Thêm vào danh sách nhân viên chung
        dsnv.themNhanVien(nvMoi);

        // Cập nhật cấp dưới cho Quản lý phụ trách
        NhanVien ql = dsnv.timNhanVien(MaQuanLy);
        if (ql instanceof QuanLy) {
            ((QuanLy) ql).themNhanVienCapDuoi(nvMoi);
        }

        return nvMoi;
    }

    public static ArrayList<NhanVienCapDuoi> chuyenTatCaUngVienDat(
            DanhSachUngVien dsuv, 
            DanhSachKetQuaDaoTao dskq, 
            String MaPhongBan, 
            String MaQuanLy, 
            DanhSachNhanVien dsnv, 
            DanhSachPhongBan dspb) {

        ArrayList<NhanVienCapDuoi> dsNVMoi = new ArrayList<>();
        ArrayList<String> dsMaUVDat = dskq.layUngVienDat();

        for (String maUV : dsMaUVDat) {
            UngVien uv = dsuv.timTheoMa(maUV);
            if (uv != null) {
                NhanVienCapDuoi nvMoi = chuyenThanhNhanVien(uv, MaPhongBan, MaQuanLy, dsnv, dspb);
                if (nvMoi != null) {
                    dsNVMoi.add(nvMoi);
                }
            }
        }
        return dsNVMoi;
    }
}
