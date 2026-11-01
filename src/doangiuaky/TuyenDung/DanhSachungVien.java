
package doangiuaky.tuyenDungDaoTao;

import java.util.ArrayList;

public class DanhSachUngVien {
    private final ArrayList<UngVien> ds;

    public DanhSachUngVien() {
        this.ds = new ArrayList<>();
    }

    public boolean them(UngVien uv, DanhSachDotTuyenDung dsDot) {
        if (timTheoMa(uv.getMaUngVien()) != null) {
            return false;
        }
        
        DotTuyenDung dtd = dsDot.timTheoMa(uv.getMaDotTuyenDung());
        if (dtd == null || !dtd.kiemTraViTri(uv.getViTriUngTuyen())) {
            return false; // Tu choi neu Dot tuyen dung hoac Vi tri khong hop le
        }
        
        return this.ds.add(uv);
    }

    public boolean xoa(String MaUngVien) {
        UngVien uv = timTheoMa(MaUngVien);
        if (uv != null) {
            return this.ds.remove(uv);
        }
        return false;
    }

    public UngVien timTheoMa(String MaUngVien) {
        for (UngVien uv : ds) {
            if (uv.getMaUngVien().equalsIgnoreCase(MaUngVien)) {
                return uv;
            }
        }
        return null;
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
