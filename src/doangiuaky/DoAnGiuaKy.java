
package doangiuaky;
import doangiuaky.nhanSu.*;
import java.util.Scanner;

public class DoAnGiuaKy {
    public static void main(String[] args) {
        DanhSachNhanVien DanhSachNhanVien = new DanhSachNhanVien();
        NhanVienCapDuoi nvcd = new NhanVienCapDuoi();
        QuanLy ql = new QuanLy();
        DanhSachPhongBan dspb = new DanhSachPhongBan();

        System.out.println("So luong nhan vien: " + DanhSachNhanVien.getds().size() + " nhan vien");
        
        System.out.println("\ndanh sach toan bo nhan vien:");
        DanhSachNhanVien.xuat();
        System.out.println("\ndanh sach nhan vien cap duoi:");
        nvcd.xuat(DanhSachNhanVien);
        System.out.println("\ndanh sach quan ly:");
        ql.xuat(DanhSachNhanVien);
        System.out.println("\ndanh sach phong ban:");
        dspb.xuat();
        
        System.out.println("\nTim kiem nhan vien:");
        Scanner sc = new Scanner(System.in);
        String manvhientai = sc.nextLine();
        NhanVien ketquatimkiem = DanhSachNhanVien.timNhanVien(manvhientai);
        if (ketquatimkiem != null) {
            System.out.println(ketquatimkiem);
        } else {
            System.out.println("Khong tim thay nhan vien voi ma: " + manvhientai);
        }

    }
}
