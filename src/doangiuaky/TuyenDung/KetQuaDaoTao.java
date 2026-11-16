package doangiuaky.tuyenDungDaoTao;

public class KetQuaDaoTao {
    public static final int DIEM_DAT_DAO_TAO = 50;

    private String MaKetQua;
    private int DiemSo;
    private String KetQua;
    private String MaUngVien;
    private String MaKhoaHoc;

    public KetQuaDaoTao() {
    }

    public KetQuaDaoTao(String MaKetQua, String MaUngVien, String MaKhoaHoc, int DiemSo) {
        this.MaKetQua = MaKetQua;
        this.MaUngVien = MaUngVien;
        this.MaKhoaHoc = MaKhoaHoc;
        setDiemSo(DiemSo);
    }

    public String getMaKetQua() { return MaKetQua; }

    public void setMaKetQua(String MaKetQua) { this.MaKetQua = MaKetQua; }

    public int getDiemSo() { return DiemSo; }

    public void setDiemSo(int DiemSo) {
        if (DiemSo < 0 || DiemSo > 100) {
            throw new IllegalArgumentException("Diem so phai tu 0 den 100!");
        }
        this.DiemSo = DiemSo;
        DanhGia();
    }

    public String getKetQua() { return KetQua; }

    public String getMaUngVien() { return MaUngVien; }

    public void setMaUngVien(String MaUngVien) { this.MaUngVien = MaUngVien; }

    public String getMaKhoaHoc() { return MaKhoaHoc; }

    public void setMaKhoaHoc(String MaKhoaHoc) { this.MaKhoaHoc = MaKhoaHoc; }

    public void DanhGia() {
        if (this.DiemSo >= DIEM_DAT_DAO_TAO) {
            this.KetQua = "Dat";
        } else {
            this.KetQua = "Khong dat";
        }
    }

    @Override
    public String toString() {
        return "Ma ket qua: " + MaKetQua +
               ", Ma ung vien: " + MaUngVien +
               ", Ma khoa hoc: " + MaKhoaHoc +
               ", Diem so: " + DiemSo +
               ", Ket qua: " + KetQua;
    }
}
