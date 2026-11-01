package doangiuaky.tuyenDungDaoTao;

import java.util.ArrayList;

public class DotTuyenDung {
    private String MaDotTuyenDung;
    private ArrayList<String> DanhSachViTri;
    private int SoLuongCanTuyen;
    private String MaNguoiDuyet; // FK kieu QuanLy

    public DotTuyenDung() {
        this.DanhSachViTri = new ArrayList<>();
    }

    public DotTuyenDung(String MaDotTuyenDung, int SoLuongCanTuyen, String MaNguoiDuyet) {
        this.MaDotTuyenDung = MaDotTuyenDung;
        this.SoLuongCanTuyen = SoLuongCanTuyen;
        this.MaNguoiDuyet = MaNguoiDuyet;
        this.DanhSachViTri = new ArrayList<>();
    }

    public String getMaDotTuyenDung() {
        return MaDotTuyenDung;
    }

    public void setMaDotTuyenDung(String MaDotTuyenDung) {
        this.MaDotTuyenDung = MaDotTuyenDung;
    }

    public ArrayList<String> getDanhSachViTri() {
        return DanhSachViTri;
    }

    public void setDanhSachViTri(ArrayList<String> DanhSachViTri) {
        this.DanhSachViTri = DanhSachViTri;
    }

    public int getSoLuongCanTuyen() {
        return SoLuongCanTuyen;
    }

    public void setSoLuongCanTuyen(int SoLuongCanTuyen) {
        this.SoLuongCanTuyen = SoLuongCanTuyen;
    }

    public String getMaNguoiDuyet() {
        return MaNguoiDuyet;
    }

    public void setMaNguoiDuyet(String MaNguoiDuyet) {
        this.MaNguoiDuyet = MaNguoiDuyet;
    }

    public void themViTri(String viTri) {
        if (!this.DanhSachViTri.contains(viTri)) {
            this.DanhSachViTri.add(viTri);
        }
    }

    public boolean kiemTraViTri(String viTri) {
        return this.DanhSachViTri.contains(viTri);
    }

    @Override
    public String toString() {
        return "Ma dot tuyen dung: " + MaDotTuyenDung + 
               ", Vi tri: " + DanhSachViTri + 
               ", So luong can tuyen: " + SoLuongCanTuyen + 
               ", Ma nguoi duyet: " + MaNguoiDuyet;
    }
}
