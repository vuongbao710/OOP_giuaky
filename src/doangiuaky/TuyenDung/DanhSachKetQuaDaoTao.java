package doangiuaky.tuyenDungDaoTao;

import java.util.ArrayList;

public class DanhSachKetQuaDaoTao {
    private final ArrayList<KetQuaDaoTao> ds;

    public DanhSachKetQuaDaoTao() { this.ds = new ArrayList<>(); }

    public boolean them(KetQuaDaoTao kq) {
        if (timTheoMa(kq.getMaKetQua()) != null) {
            return false;
        }
        return this.ds.add(kq);
    }

    public boolean xoa(String MaKetQua) {
        KetQuaDaoTao kq = timTheoMa(MaKetQua);
        if (kq != null) {
            return this.ds.remove(kq);
        }
        return false;
    }

    public KetQuaDaoTao timTheoMa(String MaKetQua) {
        for (KetQuaDaoTao kq : ds) {
            if (kq.getMaKetQua().equalsIgnoreCase(MaKetQua)) {
                return kq;
            }
        }
        return null;
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
