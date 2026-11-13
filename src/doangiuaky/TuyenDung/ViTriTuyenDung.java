package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Enum.ViTri;

public class ViTriTuyenDung {
    private String MaViTri;
    private String TenViTri;
    private String MaPhongBan;
    private int SoLuongCanTuyen;

    public ViTriTuyenDung() {
    }

    public ViTriTuyenDung(ViTri viTriEnum, String MaPhongBan, int SoLuongCanTuyen) {
        if (viTriEnum != null) {
            this.MaViTri = viTriEnum.getMaViTri();
            this.TenViTri = viTriEnum.getMoTa();
        }
        this.MaPhongBan = MaPhongBan;
        this.SoLuongCanTuyen = SoLuongCanTuyen;
    }

    public ViTriTuyenDung(String MaViTri, String TenViTri, String MaPhongBan, int SoLuongCanTuyen) {
        this.MaViTri = MaViTri;
        this.TenViTri = TenViTri;
        this.MaPhongBan = MaPhongBan;
        this.SoLuongCanTuyen = SoLuongCanTuyen;
    }

    public String getMaViTri() {
        return MaViTri;
    }

    public void setMaViTri(String MaViTri) {
        this.MaViTri = MaViTri;
    }

    public String getTenViTri() {
        return TenViTri;
    }

    public void setTenViTri(String TenViTri) {
        this.TenViTri = TenViTri;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public int getSoLuongCanTuyen() {
        return SoLuongCanTuyen;
    }

    public void setSoLuongCanTuyen(int SoLuongCanTuyen) {
        this.SoLuongCanTuyen = SoLuongCanTuyen;
    }

    @Override
    public String toString() {
        return "Ma vi tri: " + MaViTri +
               ", Ten vi tri: " + TenViTri +
               ", Ma phong ban: " + MaPhongBan +
               ", So luong can tuyen: " + SoLuongCanTuyen;
    }
}
