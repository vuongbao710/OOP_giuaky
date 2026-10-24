
package doangiuaky.nhanSu;

import java.time.LocalDate;
import java.util.ArrayList;

public class DanhSachNhanVien {
    private final ArrayList<NhanVien> ds;

    public DanhSachNhanVien() {
        this.ds = new ArrayList<>();
        dulieu();
    }

    private void dulieu() {
        QuanLy ql1 = new QuanLy("QL01", "Nguyen Van An", LocalDate.of(1985, 3, 15), "Quan ly", "0901234567", "PB01", LocalDate.of(2015, 1, 10));
        QuanLy ql2 = new QuanLy("QL02", "Tran Thi Binh", LocalDate.of(1988, 7, 20), "Quan ly", "0912345678", "PB02", LocalDate.of(2017, 5, 12));
        
        NhanVienCapDuoi nv1 = new NhanVienCapDuoi("NV01", "Le Van Cuong", LocalDate.of(1995, 2, 10), "Nhan vien", "0923456789", "PB01", LocalDate.of(2020, 3, 1), "QL01");
        NhanVienCapDuoi nv2 = new NhanVienCapDuoi("NV02", "Vu Thi Giang", LocalDate.of(2000, 4, 18), "Nhan vien", "0956789012", "PB02", LocalDate.of(2023, 8, 10), "QL02");
        
        ql1.themNhanVienCapDuoi(nv1);
        ql2.themNhanVienCapDuoi(nv2);
        
        this.ds.add(ql1);
        this.ds.add(ql2);
        this.ds.add(nv1);
        this.ds.add(nv2);
    }

    public void themNhanVien(NhanVien nv) {
        this.ds.add(nv);
    }

    public boolean xoaNhanVien(String MaNV) {
        for (NhanVien nv : ds) {
            if (nv.getMaNV().equals(MaNV)) {
                ds.remove(nv); 
                return true;  
            }
        }
        return false;
    }

    public boolean suaNhanVien(String MaNV, String HoTenMoi, String ChucVuMoi, String SDTMoi, String MaPhongBanMoi) {
        for (NhanVien nv : ds) {
            if (nv.getMaNV().equals(MaNV)) {
                nv.setHoTen(HoTenMoi);
                nv.setChucVu(ChucVuMoi);
                nv.setSDT(SDTMoi);
                nv.setMaPhongBan(MaPhongBanMoi);
                return true; 
            }
        }
        return false; 
    }

    public NhanVien timNhanVien(String MaNV) {
        for (NhanVien nv : ds) {
            if (nv.getMaNV().equals(MaNV)) {
                return nv; 
            }
        }
        return null; 
    }

    public ArrayList<NhanVien> getds() {
        return ds;
    }

    public void xuat() {
        for (NhanVien nv : ds) {
            System.out.println(nv);
        }
    }
}