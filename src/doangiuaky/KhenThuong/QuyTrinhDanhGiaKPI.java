package doangiuaky.KhenThuong;
import doangiuaky.nhanSu.NhanVien;
import java.util.ArrayList;
import java.util.Scanner;

public class QuyTrinhDanhGiaKPI {

    private ArrayList<DanhGiaKPI> dsDanhGiaKPI;

    public QuyTrinhDanhGiaKPI() {
        dsDanhGiaKPI = new ArrayList<>();
    }

    // Quan ly danh gia KPI cho tat ca nhan vien minh phu trach
    public void danhGiaNhanVien(
            String maQuanLy,
            ArrayList<NhanVien> dsNhanVien,
            int thang,
            int nam,
            Scanner sc) {

        if (thang < 1 || thang > 12 || nam <= 0) {
            throw new IllegalArgumentException(
                "Thang hoac nam khong hop le!"
            );
        }

        boolean coNhanVien = false;

        System.out.println("\n===== DANH GIA KPI NHAN VIEN =====");

        for (NhanVien nv : dsNhanVien) {

            // Chi danh gia nhan vien do minh phu trach
            if (maQuanLy.equals(nv.getMaQuanLyPhuTrach())) {

                coNhanVien = true;

                System.out.println("\nMa nhan vien: " + nv.getMaNV());
                System.out.println("Ho ten: " + nv.getHoTen());

                System.out.print("Nhap diem KPI (0 - 100): ");
                int diem = sc.nextInt();

                // Tao ma danh gia
                String maDanhGia = "DG" + (dsDanhGiaKPI.size() + 1);

                // Tao doi tuong danh gia KPI
                DanhGiaKPI dg = new DanhGiaKPI(
                    maDanhGia,
                    diem,
                    thang,
                    nam,
                    maQuanLy,
                    nv.getMaNV()
                );

                // Them vao danh sach danh gia
                dsDanhGiaKPI.add(dg);

                System.out.println("Danh gia thanh cong!");
                System.out.println("Xep loai: " + dg.getXepLoai());
                System.out.println("He so KPI: " + dg.getHeSoKPI());
            }
        }

        if (!coNhanVien) {
            System.out.println(
                "Khong co nhan vien nao thuoc quyen quan ly cua ban!"
            );
        }
    }

    // Xuat danh sach danh gia KPI
    public void xuatDanhSachKPI() {

        if (dsDanhGiaKPI.isEmpty()) {
            System.out.println("Danh sach danh gia KPI rong!");
            return;
        }

        System.out.println("\n===== DANH SACH DANH GIA KPI =====");

        for (DanhGiaKPI dg : dsDanhGiaKPI) {
            System.out.println("---------------------------");
            System.out.println(dg);
        }
    }

    // Tim kiem danh gia theo ma nhan vien
    public void timKiemTheoMaNV(String maNV) {

        boolean timThay = false;

        for (DanhGiaKPI dg : dsDanhGiaKPI) {

            if (dg.getMaNVNhanDanhGia().equals(maNV)) {
                System.out.println(dg);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay danh gia KPI!");
        }
    }

    public ArrayList<DanhGiaKPI> getDsDanhGiaKPI() {
        return dsDanhGiaKPI;
    }
}
