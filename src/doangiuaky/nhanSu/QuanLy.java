
package doangiuaky.nhanSu;


import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLy extends NhanVien {
    private ArrayList<NhanVienCapDuoi> DanhSachNhanVienDuoiTruong;

    public QuanLy() {
        this.DanhSachNhanVienDuoiTruong = new ArrayList<>();
    }

    public QuanLy(String MaNV, String HoTen, LocalDate NgaySinh, String ChucVu, String SDT, String MaPhongBan, LocalDate NgayVaoLam) {
        super(MaNV, HoTen, NgaySinh, ChucVu, SDT, MaPhongBan, NgayVaoLam);
        super.setChucVu("Quan Ly");
        this.DanhSachNhanVienDuoiTruong = new ArrayList<>();
    }

    @Override
    public long tinhLuongThucTe() {
        return 10000000;
    }

    public ArrayList<NhanVienCapDuoi> getDanhSachNhanVienDuoiTruong() {
        return DanhSachNhanVienDuoiTruong;
    }

    public void setDanhSachNhanVienDuoiTruong(ArrayList<NhanVienCapDuoi> DanhSachNhanVienDuoiTruong) {
        this.DanhSachNhanVienDuoiTruong = DanhSachNhanVienDuoiTruong;
    }

    public void themNhanVienCapDuoi(NhanVienCapDuoi nv) {
        this.DanhSachNhanVienDuoiTruong.add(nv);
    }

    public ArrayList<NhanVien> DanhSachNhanVien(DanhSachNhanVien DanhSachNhanVien) {
        ArrayList<NhanVien> ketqua = new ArrayList<>();

        for (NhanVien nv : DanhSachNhanVien.getds()) {
            if (nv.getChucVu().equals("Quan ly")) {
                ketqua.add(nv);
            }
        }
        return ketqua;
    }

    public void xuatDanhSachNhanVienDuoiTruong(DanhSachNhanVien DanhSachNhanVien) {
        int sothutu = 1;
        for (NhanVien NhanVien : DanhSachNhanVien.getds()) {
            if (NhanVien.getChucVu().equals("Quan ly")) {
                System.out.println("STT: " + sothutu++);
                System.out.println("  Ma NV: " + NhanVien.getMaNV());
                System.out.println("  Ho va Ten: " + NhanVien.getHoTen());
                System.out.println("  Ngay sinh: " + NhanVien.getNgaySinh());
                System.out.println("  Chuc vu: " + NhanVien.getChucVu());
                System.out.println("  So dien thoai: " + NhanVien.getSDT());
                System.out.println("  Ma phong ban: " + NhanVien.getMaPhongBan());
                System.out.println("  Luong co ban: " + NhanVien.tinhLuongThucTe());
            }
        }
    }
    public void xuat(DanhSachNhanVien DanhSachNhanVien) {
        for (NhanVien nv : DanhSachNhanVien.getds()) {
            if (nv.getChucVu().equals("Quan ly")) {
                System.out.println(nv);
            }
        }
    }
}
