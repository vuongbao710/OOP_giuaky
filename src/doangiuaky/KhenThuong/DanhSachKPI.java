package doangiuaky.KhenThuong;
import doangiuaky.Interface.DanhSach;
public class DanhSachKPI implements DanhSach<DanhGiaKPI> {

    private DanhGiaKPI[] danhSach;
    private int soLuong;

    // Constructor
    public DanhSachKPI() {
        danhSach = new DanhGiaKPI[100];
        soLuong = 0;
    }

    // Them KPI
    @Override
    public void them(DanhGiaKPI item) {

        if (item == null || soLuong >= danhSach.length) {
            System.out.println("Khong the them KPI!");
            return;
        }

        if (timKiem(item.getMaDanhGia()) != null) {
            System.out.println("Ma KPI da ton tai!");
            return;
        }

        danhSach[soLuong] = item;
        soLuong++;

        System.out.println("Them KPI thanh cong!");
    }

    // Xoa KPI
    @Override
    public void xoa(DanhGiaKPI item) {

        if (item == null) {
            return;
        }

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i].getMaDanhGia()
                    .equals(item.getMaDanhGia())) {

                for (int j = i; j < soLuong - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }

                danhSach[soLuong - 1] = null;
                soLuong--;

                System.out.println("Xoa KPI thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay KPI!");
    }

    // Xuat danh sach
    @Override
    public void xuat() {

        if (soLuong == 0) {
            System.out.println("Danh sach KPI rong!");
            return;
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("-------------------");
            System.out.println(danhSach[i]);
        }
    }

    // Tim kiem theo ma
    @Override
    public DanhGiaKPI timKiem(String maDG) {

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i].getMaDanhGia().equals(maDG)) {
                return danhSach[i];
            }
        }

        return null;
    }

    // Getter
    public int getSoLuong() {
        return soLuong;
    }

    public DanhGiaKPI[] getDanhSach() {
        return danhSach;
    }
}
