package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Interface.DanhSach;
import java.util.ArrayList;

public class DanhSachUngVien implements DanhSach<UngVien> {
    private final ArrayList<UngVien> ds;

    public DanhSachUngVien() {
        this.ds = new ArrayList<>();
    }

    @Override
    public void them(UngVien uv) {
        if (uv != null && timKiem(uv.getMaUngVien()) == null) {
            this.ds.add(uv);
        }
    }

    public boolean them(UngVien uv, DanhSachDotTuyenDung dsDot) {
        if (uv == null || timKiem(uv.getMaUngVien()) != null) {
            return false;
        }
        DotTuyenDung dtd = dsDot.timKiem(uv.getMaDotTuyenDung());
        if (dtd == null || !dtd.kiemTraViTri(uv.getMaViTriUngTuyen())) {
            return false;
        }
        return this.ds.add(uv);
    }

    @Override
    public void xoa(UngVien uv) {
        if (uv != null) {
            this.ds.remove(uv);
        }
    }

    public boolean xoaTheoMa(String MaUngVien) {
        UngVien uv = timKiem(MaUngVien);
        if (uv != null) {
            return this.ds.remove(uv);
        }
        return false;
    }

    @Override
    public UngVien timKiem(String MaUngVien) {
        for (UngVien uv : ds) {
            if (uv.getMaUngVien().equalsIgnoreCase(MaUngVien)) {
                return uv;
            }
        }
        return null;
    }

    @Override
    public void xuat() {
        for (UngVien uv : ds) {
            System.out.println(uv);
        }
    }

    public ArrayList<UngVien> layTheoDot(String MaDot) {
        ArrayList<UngVien> res = new ArrayList<>();
        for (UngVien uv : ds) {
            if (uv.getMaDotTuyenDung().equalsIgnoreCase(MaDot)) {
                res.add(uv);
            }
        }
        return res;
    }

    public ArrayList<UngVien> layTatCa() {
        return ds;
    }
}
