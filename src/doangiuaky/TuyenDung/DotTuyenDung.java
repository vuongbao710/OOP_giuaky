package doangiuaky.tuyenDungDaoTao;

import java.time.LocalDate;
import java.util.ArrayList;

public class DotTuyenDung {
    private String MaDotTuyenDung;
    private String MaNguoiDuyet;
    private ArrayList<ViTriTuyenDung> DanhSachViTri;
    private int SoLuongCanTuyen;
    private LocalDate NgayTuyenDung;

    public DotTuyenDung() {
        this.DanhSachViTri = new ArrayList<>();
    }

    public DotTuyenDung(String MaDotTuyenDung, String MaNguoiDuyet, int SoLuongCanTuyen, LocalDate NgayTuyenDung) {
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.MaNguoiDuyet = MaNguoiDuyet;
        this.SoLuongCanTuyen = SoLuongCanTuyen;
        this.NgayTuyenDung = NgayTuyenDung;
        this.DanhSachViTri = new ArrayList<>();
    }

    public String getMaDotTuyenDung() {
        return MaDotTuyenDung;
    }

    public void setMaDotTuyenDung(String MaDotTuyenDung) {
        this.MaDotTuyenDung = MaDotTuyenDung;
    }

    public String getMaNguoiDuyet() {
        return MaNguoiDuyet;
    }

    public void setMaNguoiDuyet(String MaNguoiDuyet) {
        this.MaNguoiDuyet = MaNguoiDuyet;
    }

    public ArrayList<ViTriTuyenDung> getDanhSachViTri() {
        return DanhSachViTri;
    }

    public void setDanhSachViTri(ArrayList<ViTriTuyenDung> DanhSachViTri) {
        this.DanhSachViTri = DanhSachViTri;
    }

    public int getSoLuongCanTuyen() {
        return SoLuongCanTuyen;
    }

    public void setSoLuongCanTuyen(int SoLuongCanTuyen) {
        this.SoLuongCanTuyen = SoLuongCanTuyen;
    }

    public LocalDate getNgayTuyenDung() {
        return NgayTuyenDung;
    }

    public void setNgayTuyenDung(LocalDate NgayTuyenDung) {
        this.NgayTuyenDung = NgayTuyenDung;
    }

    public void themViTri(ViTriTuyenDung vt) {
        if (vt != null && timViTri(vt.getMaViTri()) == null) {
            this.DanhSachViTri.add(vt);
        }
    }

    public ViTriTuyenDung timViTri(String maViTri) {
        for (ViTriTuyenDung vt : DanhSachViTri) {
            if (vt.getMaViTri().equalsIgnoreCase(maViTri)) {
                return vt;
            }
        }
        return null;
    }

    public boolean kiemTraViTri(String maViTri) {
        return timViTri(maViTri) != null;
    }

    @Override
    public String toString() {
        return "Ma dot tuyen dung: " + MaDotTuyenDung +
               ", Ma nguoi duyet: " + MaNguoiDuyet +
               ", Ngay tuyen dung: " + NgayTuyenDung +
               ", So luong can tuyen: " + SoLuongCanTuyen +
               ", Danh sach vi tri: " + DanhSachViTri;
    }
}
