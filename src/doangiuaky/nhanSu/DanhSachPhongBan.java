
package doangiuaky.nhanSu;

import java.util.ArrayList;

public class DanhSachPhongBan {
    private final ArrayList<PhongBan> DanhSachPhongBan;

    public DanhSachPhongBan() {
        this.DanhSachPhongBan = new ArrayList<>();
        dulieu();
    }

    private void dulieu() {
        PhongBan phongban1 = new PhongBan("PB01", "Phong Ky Thuat", "QL01", "Nguyen Van An");
        PhongBan phongban2 = new PhongBan("PB02", "Phong Nhan Su", "QL02", "Tran Thi Binh");

        this.DanhSachPhongBan.add(phongban1);
        this.DanhSachPhongBan.add(phongban2);
    }

    public void themPhongBan(PhongBan phongban) {
        this.DanhSachPhongBan.add(phongban);
    }

    public boolean xoaPhongBan(String MaPhongBan) {
        for (PhongBan pb : DanhSachPhongBan) {
            if (pb.getMaPhongBan().equals(MaPhongBan)) {
                this.DanhSachPhongBan.remove(pb);
                return true;
            }
        }
        return false; 
    }

    public boolean suaPhongBan(String MaPhongBan, String TenPhongBanMoi, String MaTruongPhongMoi, String TenTruongPhongMoi) {
        for (PhongBan pb : DanhSachPhongBan) {
            if (pb.getMaPhongBan().equals(MaPhongBan)) {
                pb.setTenPhongBan(TenPhongBanMoi);
                pb.setMaTruongPhong(MaTruongPhongMoi);
                pb.setTenTruongPhong(TenTruongPhongMoi);
                return true; 
            }
        }
        return false; 
    }

    public PhongBan timPhongBan(String MaPhongBan) {
        for (PhongBan pb : DanhSachPhongBan) {
            if (pb.getMaPhongBan().equals(MaPhongBan)) {
                return pb; 
            }
        }
        return null; 
    }

    public ArrayList<PhongBan> getdanhsachphongban() {
        return this.DanhSachPhongBan;
    }
    public void xuat() {
        for (PhongBan pb : this.DanhSachPhongBan) {
            System.out.println(pb);
        }
    }
}
