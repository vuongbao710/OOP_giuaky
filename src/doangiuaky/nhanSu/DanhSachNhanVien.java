
package doangiuaky.nhanSu;

import java.time.LocalDate;
import java.util.ArrayList;

public class DanhSachNhanVien {
    private final ArrayList<NhanVien> ds;

    public DanhSachNhanVien() {
        this.ds = new ArrayList<>();
       
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