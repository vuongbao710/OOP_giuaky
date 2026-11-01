package doangiuaky.tuyenDungDaoTao;

import java.util.ArrayList;

public class DanhSachKhoaDaoTao {
    private final ArrayList<KhoaDaoTao> ds;

    public DanhSachKhoaDaoTao() { this.ds = new ArrayList<>(); }

    public boolean them(KhoaDaoTao kdt) {
        if (timTheoMa(kdt.getMaKhoaHoc()) != null) {
            return false;
        }
        return this.ds.add(kdt);
    }

    public boolean xoa(String MaKhoaHoc) {
        KhoaDaoTao kdt = timTheoMa(MaKhoaHoc);
        if (kdt != null) {
            return this.ds.remove(kdt);
        }
        return false;
    }

    public KhoaDaoTao timTheoMa(String MaKhoaHoc) {
        for (KhoaDaoTao kdt : ds) {
            if (kdt.getMaKhoaHoc().equalsIgnoreCase(MaKhoaHoc)) {
                return kdt;
            }
        }
        return null;
    }

    public ArrayList<KhoaDaoTao> layTatCa() {
        return ds;
    }
}
