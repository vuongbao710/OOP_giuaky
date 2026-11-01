package doangiuaky.tuyenDungDaoTao;

import java.util.ArrayList;

public class DanhSachDotTuyenDung {
    private final ArrayList<DotTuyenDung> ds;

    public DanhSachDotTuyenDung() {
        this.ds = new ArrayList<>();
    }

    public boolean them(DotTuyenDung dtd) {
        if (timTheoMa(dtd.getMaDotTuyenDung()) != null) {
            return false;
        }
        return this.ds.add(dtd);
    }

    public boolean xoa(String MaDot) {
        DotTuyenDung dtd = timTheoMa(MaDot);
        if (dtd != null) {
            return this.ds.remove(dtd);
        }
        return false;
    }

    public DotTuyenDung timTheoMa(String MaDot) {
        for (DotTuyenDung dtd : ds) {
            if (dtd.getMaDotTuyenDung().equalsIgnoreCase(MaDot)) {
                return dtd;
            }
        }
        return null;
    }

    public ArrayList<DotTuyenDung> layTatCa() {
        return ds;
    }
}
