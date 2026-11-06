
package doangiuaky.KhenThuong;

import doangiuaky.nhanSu.DanhSachNhanVien;
import doangiuaky.nhanSu.NhanVien;
import java.util.ArrayList;

public class DanhSachKhenThuongKyLuat {

    private ArrayList<KhenThuongKyLuat> danhSach;

    public DanhSachKhenThuongKyLuat() {
        danhSach = new ArrayList<>();
    }

    public ArrayList<KhenThuongKyLuat> getDanhSach() {
        return danhSach;
    }

    public void setDanhSach(
            ArrayList<KhenThuongKyLuat> danhSach) {

        this.danhSach = danhSach;
    }

    // Them quyet dinh
    public boolean them(
            KhenThuongKyLuat qd,
            DanhSachNhanVien dsnv) {

        if (qd == null || dsnv == null) {
            return false;
        }

        // Kiem tra ma quyet dinh trung
        if (timTheoMa(qd.getMaQD()) != null) {
            return false;
        }

        // Kiem tra nhan vien nhan quyet dinh co ton tai khong
        NhanVien nv = dsnv.timTheoMa(
                qd.getMaNhanVienNhanQD()
        );

        if (nv == null) {
            return false;
        }

        // Neu la khen thuong thi kiem tra quy tac
        if (qd instanceof KhenThuong) {

            KhenThuong kt = (KhenThuong) qd;

            if (!kt.kiemTraHopLe(nv, this)) {
                return false;
            }
        }

        danhSach.add(qd);
        return true;
    }

    // Tim quyet dinh theo ma
    public KhenThuongKyLuat timTheoMa(String maQD) {

        for (KhenThuongKyLuat qd : danhSach) {

            if (qd.getMaQD().equals(maQD)) {
                return qd;
            }
        }

        return null;
    }

    // Xoa quyet dinh theo ma
    public boolean xoa(String maQD) {

        KhenThuongKyLuat qd = timTheoMa(maQD);

        if (qd == null) {
            return false;
        }

        danhSach.remove(qd);
        return true;
    }

    // Lay tat ca quyet dinh cua mot nhan vien
    public ArrayList<KhenThuongKyLuat> layTheoNhanVien(
            String maNV) {

        ArrayList<KhenThuongKyLuat> ketQua =
                new ArrayList<>();

        for (KhenThuongKyLuat qd : danhSach) {

            if (qd.getMaNhanVienNhanQD().equals(maNV)) {
                ketQua.add(qd);
            }
        }

        return ketQua;
    }

    // Tong tien tac dong trong mot thang va nam
    public long tongTacDong(
            String maNV, int thang, int nam) {

        long tong = 0;

        for (KhenThuongKyLuat qd : danhSach) {

            if (qd.getMaNhanVienNhanQD().equals(maNV)
                    && qd.getNgayBanHanh() != null
                    && qd.getNgayBanHanh().getMonthValue() == thang
                    && qd.getNgayBanHanh().getYear() == nam) {

                tong += qd.tinhTacDongLuong();
            }
        }

        return tong;
    }
}
