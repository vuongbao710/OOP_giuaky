package doangiuaky.ChamCong;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BangChamCong implements QuanLyChamCong<ChamCong> {
    public static final int SUC_CHUA_MAC_DINH = 100;

    private final ChamCong[] danhSach;
    private int soLuong;

    public BangChamCong() {
        this(SUC_CHUA_MAC_DINH);
    }

    public BangChamCong(int sucChua) {
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Suc chua phai lon hon 0");
        }
        danhSach = new ChamCong[sucChua];
    }

    @Override
    public void them(ChamCong chamCong) {
        if (chamCong == null) {
            throw new IllegalArgumentException("Cham cong khong duoc null");
        }
        if (timChinhXac(chamCong.getMaCC()) != null) {
            throw new IllegalArgumentException("Bang cham cong da ton tai ma");
        }
        if (soLuong == danhSach.length) {
            throw new IllegalStateException("Bang cham cong da day");
        }
        danhSach[soLuong++] = chamCong;
    }

    public void themNhieu(List<? extends ChamCong> cacChamCong) {
        if (cacChamCong == null) {
            throw new IllegalArgumentException("Danh sach cham cong khong duoc null");
        }
        for (ChamCong chamCong : cacChamCong) {
            them(chamCong);
        }
    }

    public boolean sua(String maCC, String maNV, YearMonth thangNam) {
        ChamCong chamCong = timChinhXac(maCC);
        if (chamCong == null) {
            return false;
        }
        chamCong.suaThongTin(maNV, thangNam);
        return true;
    }

    @Override
    public boolean xoa(String maCC) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaCC().equalsIgnoreCase(maCC)) {
                int soPhanTuCanDich = soLuong - i - 1;
                if (soPhanTuCanDich > 0) {
                    System.arraycopy(danhSach, i + 1, danhSach, i, soPhanTuCanDich);
                }
                danhSach[--soLuong] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public ChamCong timChinhXac(String maCC) {
        if (maCC == null) {
            return null;
        }
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaCC().equalsIgnoreCase(maCC)) {
                return danhSach[i];
            }
        }
        return null;
    }

    @Override
    public List<ChamCong> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<ChamCong> ketQua = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            ChamCong chamCong = danhSach[i];
            if (chamCong.getMaCC().toLowerCase().contains(khoa)
                    || chamCong.getMaNV().toLowerCase().contains(khoa)) {
                ketQua.add(chamCong);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public List<ChamCong> getDanhSach() {
        ArrayList<ChamCong> ketQua = new ArrayList<>(soLuong);
        for (int i = 0; i < soLuong; i++) {
            ketQua.add(danhSach[i]);
        }
        return Collections.unmodifiableList(ketQua);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getSucChua() {
        return danhSach.length;
    }

    public double tinhNgayCongThucTe() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].tinhNgayCongThucTe();
        }
        return tong;
    }

    @Override
    public void ghiFile(Path tep) throws IOException {
        ArrayList<String> dong = new ArrayList<>(soLuong);
        for (int i = 0; i < soLuong; i++) {
            dong.add(toDong(danhSach[i]));
        }
        Files.write(tep, dong);
    }

    @Override
    public void docFile(Path tep) throws IOException {
        soLuong = 0;
        for (String dong : Files.readAllLines(tep)) {
            if (dong.trim().isEmpty()) {
                continue;
            }
            try {
                String[] cot = dong.split("\\|", -1);
                if (cot.length != 5) {
                    throw new IOException("Dong du lieu khong hop le: " + dong);
                }
                YearMonth thang = YearMonth.parse(cot[3]);
                if ("HANH_CHINH".equals(cot[0])) {
                    int[] ngay = new int[cot[4].length()];
                    for (int i = 0; i < ngay.length; i++) {
                        if (cot[4].charAt(i) == '1') {
                            ngay[i] = i + 1;
                        } else if (cot[4].charAt(i) != '0') {
                            throw new IOException("Ngay cong khong hop le: " + dong);
                        }
                    }
                    them(new ChamCongHanhChinh(cot[1], cot[2], thang, ngay));
                } else if ("CA_DAC_BIET".equals(cot[0])) {
                    ChamCongCaDacBiet ca = new ChamCongCaDacBiet(cot[1], cot[2], thang);
                    String[] ngay = cot[4].isEmpty() ? new String[0] : cot[4].split(";");
                    for (int i = 0; i < ngay.length; i++) {
                        String[] giaTri = ngay[i].split(":");
                        if (giaTri.length != 2) {
                            throw new IOException("Du lieu ca khong hop le: " + dong);
                        }
                        ca.ghiNhan(i + 1, Double.parseDouble(giaTri[0]),
                                Boolean.parseBoolean(giaTri[1]));
                    }
                    them(ca);
                } else {
                    throw new IOException("Loai cham cong khong hop le: " + cot[0]);
                }
            } catch (RuntimeException ex) {
                throw new IOException("Khong doc duoc dong: " + dong, ex);
            }
        }
    }

    private static String toDong(ChamCong chamCong) {
        if (chamCong instanceof ChamCongHanhChinh) {
            StringBuilder ngay = new StringBuilder();
            for (int giaTri : ((ChamCongHanhChinh) chamCong).getNgayCong()) {
                ngay.append(giaTri);
            }
            return "HANH_CHINH|" + chamCong.getMaCC() + "|" + chamCong.getMaNV()
                    + "|" + chamCong.getThangNam() + "|" + ngay;
        }
        if (chamCong instanceof ChamCongCaDacBiet) {
            ChamCongCaDacBiet ca = (ChamCongCaDacBiet) chamCong;
            double[] gio = ca.getGioTangCa();
            boolean[] ngayLe = ca.getNgayLe();
            StringBuilder duLieu = new StringBuilder();
            for (int i = 0; i < gio.length; i++) {
                if (i > 0) {
                    duLieu.append(';');
                }
                duLieu.append(gio[i]).append(':').append(ngayLe[i]);
            }
            return "CA_DAC_BIET|" + chamCong.getMaCC() + "|" + chamCong.getMaNV()
                    + "|" + chamCong.getThangNam() + "|" + duLieu;
        }
        throw new IllegalArgumentException("Khong ho tro kieu cham cong: "
                + chamCong.getClass().getName());
    }
}
