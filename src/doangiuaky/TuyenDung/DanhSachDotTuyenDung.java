package doangiuaky.tuyenDungDaoTao;

import doangiuaky.Interface.DanhSach;
import java.util.Arrays;

public class DanhSachDotTuyenDung implements DanhSach<DotTuyenDung> {
    private DotTuyenDung[] ds;
    private int soLuong;

    public DanhSachDotTuyenDung() {
        this.ds = new DotTuyenDung[100];
        this.soLuong = 0;
    }

    @Override
    public void them(DotTuyenDung dtd) {
        if (dtd == null || timKiem(dtd.getMaDotTuyenDung()) != null) {
            return;
        }
        if (soLuong >= ds.length) {
            ds = Arrays.copyOf(ds, ds.length * 2);
        }
        ds[soLuong++] = dtd;
    }

    @Override
    public void xoa(DotTuyenDung dtd) {
        if (dtd != null) {
            xoaTheoMa(dtd.getMaDotTuyenDung());
        }
    }

    public boolean xoaTheoMa(String MaDot) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDotTuyenDung().equalsIgnoreCase(MaDot)) {
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
    public DotTuyenDung timKiem(String MaDot) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDotTuyenDung().equalsIgnoreCase(MaDot)) {
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

    public DotTuyenDung[] layTatCa() {
        return Arrays.copyOf(ds, soLuong);
    }

    public int getSoLuong() {
        return soLuong;
    }
}
