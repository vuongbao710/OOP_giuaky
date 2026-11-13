package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Interface.DanhSach;
import java.util.Arrays;

public class DanhSachKhoaDaoTao implements DanhSach<KhoaDaoTao> {
    private KhoaDaoTao[] ds;
    private int soLuong;

    public DanhSachKhoaDaoTao() {
        this.ds = new KhoaDaoTao[100];
        this.soLuong = 0;
    }

    @Override
    public void them(KhoaDaoTao kdt) {
        if (kdt == null || timKiem(kdt.getMaKhoaHoc()) != null) {
            return;
        }
        if (soLuong >= ds.length) {
            ds = Arrays.copyOf(ds, ds.length * 2);
        }
        ds[soLuong++] = kdt;
    }

    @Override
    public void xoa(KhoaDaoTao kdt) {
        if (kdt != null) {
            xoaTheoMa(kdt.getMaKhoaHoc());
        }
    }

    public boolean xoaTheoMa(String MaKhoaHoc) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaKhoaHoc().equalsIgnoreCase(MaKhoaHoc)) {
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds[--soLuong] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public KhoaDaoTao timKiem(String MaKhoaHoc) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaKhoaHoc().equalsIgnoreCase(MaKhoaHoc)) {
                return ds[i];
            }
        }
        return null;
    }

    @Override
    public void xuat() {
        for (int i = 0; i < soLuong; i++) {
            System.out.println(ds[i]);
        }
    }

    public KhoaDaoTao[] layTatCa() {
        return Arrays.copyOf(ds, soLuong);
    }

    public int getSoLuong() {
        return soLuong;
    }
}
