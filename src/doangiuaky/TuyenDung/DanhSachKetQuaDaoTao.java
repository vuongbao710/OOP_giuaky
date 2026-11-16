package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Interface.DanhSach;
import java.util.ArrayList;

public class DanhSachKetQuaDaoTao implements DanhSach<KetQuaDaoTao> {
    private final ArrayList<KetQuaDaoTao> ds;

    public DanhSachKetQuaDaoTao() {
        this.ds = new ArrayList<>();
    }

    @Override
    public void them(KetQuaDaoTao kq) {
        if (kq != null && timKiem(kq.getMaKetQua()) == null) {
            this.ds.add(kq);
        }
    }

    @Override
    public void xoa(KetQuaDaoTao kq) {
        if (kq != null) {
            this.ds.remove(kq);
        }
    }

    public boolean xoaTheoMa(String MaKetQua) {
        KetQuaDaoTao kq = timKiem(MaKetQua);
        if (kq != null) {
            return this.ds.remove(kq);
        }
        return false;
    }

    @Override
    public KetQuaDaoTao timKiem(String MaKetQua) {
        for (KetQuaDaoTao kq : ds) {
            if (kq.getMaKetQua().equalsIgnoreCase(MaKetQua)) {
                return kq;
            }
        }
        return null;
    }

    @Override
    public void xuat() {
        for (KetQuaDaoTao kq : ds) {
            System.out.println(kq);
        }
    }

    public ArrayList<String> layUngVienDat() {
        ArrayList<String> dsMaUV = new ArrayList<>();
        for (KetQuaDaoTao kq : ds) {
            if ("Dat".equalsIgnoreCase(kq.getKetQua())) {
                if (!dsMaUV.contains(kq.getMaUngVien())) {
                    dsMaUV.add(kq.getMaUngVien());
                }
            }
        }
        return dsMaUV;
    }

    public ArrayList<KetQuaDaoTao> layTatCa() {
        return ds;
    }
}
