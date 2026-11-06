
package doangiuaky.KhenThuong;

public class DanhGiaKPI {

    private String maDanhGia;
    private int diemKPI;
    private String xepLoai;
    private double heSoKPI;
    private int thang;
    private int nam;
    private String maNVDanhGia;
    private String maNVNhanDanhGia;

    public DanhGiaKPI(String maDanhGia,int diemKPI,int thang,int nam,String maNVDanhGia,String maNVNhanDanhGia)
     {
        this.maDanhGia = maDanhGia;
        this.thang = thang;
        this.nam = nam;
        this.maNVDanhGia = maNVDanhGia;
        this.maNVNhanDanhGia = maNVNhanDanhGia;

        setDiemKPI(diemKPI);
    }

    public String getMaDanhGia() {
        return maDanhGia;
    }

    public void setMaDanhGia(String maDanhGia) {
        this.maDanhGia = maDanhGia;
    }

    public int getDiemKPI() {
        return diemKPI;
    }

    public void setDiemKPI(int diemKPI) {

        if (diemKPI < 0 || diemKPI > 100) {
            throw new IllegalArgumentException(
                "Diem KPI phai tu 0 den 100!"
            );
        }

        this.diemKPI = diemKPI;

        // Sau khi gan diem thi cap nhat xep loai va he so
        xepLoaiTuDiem();
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public double getHeSoKPI() {
        return heSoKPI;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        if (thang < 1 || thang > 12) {
            throw new IllegalArgumentException(
                "Thang phai tu 1 den 12!"
            );
        }

        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        if (nam <= 0) {
            throw new IllegalArgumentException(
                "Nam phai lon hon 0!"
            );
        }

        this.nam = nam;
    }

    public String getMaNVDanhGia() {
        return maNVDanhGia;
    }

    public void setMaNVDanhGia(String maNVDanhGia) {
        this.maNVDanhGia = maNVDanhGia;
    }

    public String getMaNVNhanDanhGia() {
        return maNVNhanDanhGia;
    }

    public void setMaNVNhanDanhGia(String maNVNhanDanhGia) {
        this.maNVNhanDanhGia = maNVNhanDanhGia;
    }

    // Tu dong xep loai va tinh he so KPI
    public void xepLoaiTuDiem() {

        if (diemKPI >= 90) {
            xepLoai = "Xuat sac";
            heSoKPI = 2.0;
        } else if (diemKPI >= 80) {
            xepLoai = "Tot";
            heSoKPI = 1.5;
        } else if (diemKPI >= 65) {
            xepLoai = "Dat";
            heSoKPI = 1.2;
        } else {
            xepLoai = "Khong dat";
            heSoKPI = 1.0;
        }
    }

    @Override
    public String toString() {
        return "Ma danh gia: " + maDanhGia
                + "\nDiem KPI: " + diemKPI
                + "\nXep loai: " + xepLoai
                + "\nHe so KPI: " + heSoKPI
                + "\nThang: " + thang
                + "\nNam: " + nam
                + "\nMa nguoi danh gia: " + maNVDanhGia
                + "\nMa nhan vien: " + maNVNhanDanhGia;
    }
}
