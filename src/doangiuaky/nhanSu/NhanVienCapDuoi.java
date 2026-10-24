package doangiuaky.nhanSu;

import java.time.LocalDate;
import java.util.ArrayList;

public class NhanVienCapDuoi extends NhanVien {
    private String MaQuanLyPhuTrach;

    public NhanVienCapDuoi() {
    }

    public NhanVienCapDuoi(String MaNV, String HoTen, LocalDate NgaySinh, String ChucVu, String SDT, String MaPhongBan, LocalDate NgayVaoLam, String MaQuanLyPhuTrach) {
        super(MaNV, HoTen, NgaySinh, ChucVu, SDT, MaPhongBan, NgayVaoLam);
        super.setChucVu("Nhan vien");
        this.MaQuanLyPhuTrach = MaQuanLyPhuTrach;
    }

    @Override
    public long tinhLuongThucTe() {
        return 5000000;//tam thoi de vay
    }

    public String getMaQuanLyPhuTrach() {
        return MaQuanLyPhuTrach;
    }

    public void setMaQuanLyPhuTrach(String MaQuanLyPhuTrach) {
        this.MaQuanLyPhuTrach = MaQuanLyPhuTrach;
    }
    
    public ArrayList<NhanVien> danhsachnhanvien(DanhSachNhanVien danhsachnhanvien) {
        ArrayList<NhanVien> ketqua = new ArrayList<>();

        for (NhanVien nv : danhsachnhanvien.getds()) {
            if (nv.getChucVu().equals("Nhan vien")) {
                ketqua.add(nv);
            }
        }
        return ketqua;
    }
    
    public void xuat(DanhSachNhanVien danhsachnhanvien) {
        for (NhanVien nv : danhsachnhanvien.getds()) {
            if (nv.getChucVu().equals("Nhan vien")) {
                NhanVienCapDuoi nvcd = (NhanVienCapDuoi) nv;
                System.out.println(nv.toString() + ", Ma quan ly phu trach: " + nvcd.getMaQuanLyPhuTrach());
            }
        }
    }
}