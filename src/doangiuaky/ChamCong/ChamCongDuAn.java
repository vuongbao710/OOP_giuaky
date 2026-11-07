package doangiuaky.ChamCong;

import java.io.IOException;
import java.nio.file.Path;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChamCongDuAn extends ChamCong implements QuanLyChamCong<ChamCong> {
    private final String tenDuAn;
    private final ArrayList<ChamCong> danhSach;

    public ChamCongDuAn(String maCC, String maNV, YearMonth thangNam, String tenDuAn) {
        super(maCC, maNV, thangNam);
        if (tenDuAn == null || tenDuAn.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten du an khong duoc rong");
        }
        this.tenDuAn = tenDuAn.trim();
        this.danhSach = new ArrayList<>();
    }

    public String getTenDuAn() { return tenDuAn; }

    @Override
    public double tinhNgayCongThucTe() {
        return danhSach.stream().mapToDouble(ChamCong::tinhNgayCongThucTe).sum();
    }

    @Override
    public void them(ChamCong chamCong) {
        if (chamCong == null || timChinhXac(chamCong.getMaCC()) != null) {
            throw new IllegalArgumentException("Du an da ton tai ma cham cong");
        }
        danhSach.add(chamCong);
    }

    @Override
    public boolean xoa(String maCC) {
        return danhSach.removeIf(c -> c.getMaCC().equalsIgnoreCase(maCC));
    }

    @Override
    public ChamCong timChinhXac(String maCC) {
        for (ChamCong c : danhSach) {
            if (c.getMaCC().equalsIgnoreCase(maCC)) return c;
        }
        return null;
    }

    @Override
    public List<ChamCong> timGanDung(String tuKhoa) {
        String khoa = tuKhoa == null ? "" : tuKhoa.toLowerCase();
        ArrayList<ChamCong> ketQua = new ArrayList<>();
        for (ChamCong c : danhSach) {
            if (c.getMaCC().toLowerCase().contains(khoa)
                    || c.getMaNV().toLowerCase().contains(khoa)
                    || tenDuAn.toLowerCase().contains(khoa)) {
                ketQua.add(c);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public List<ChamCong> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }

    @Override
    public void ghiFile(Path tep) throws IOException {
        ArrayList<String> dong = new ArrayList<>();
        for (ChamCong c : danhSach) {
            if (c instanceof ChamCongHanhChinh) {
                StringBuilder ngay = new StringBuilder();
                for (int giaTri : ((ChamCongHanhChinh) c).getNgayCong()) {
                    ngay.append(giaTri);
                }
                dong.add("HANH_CHINH|" + c.getMaCC() + "|" + c.getMaNV() + "|"
                        + c.getThangNam() + "|" + ngay);
            } else if (c instanceof ChamCongCaDacBiet) {
                ChamCongCaDacBiet ca = (ChamCongCaDacBiet) c;
                double[] gio = ca.getGioTangCa();
                boolean[] ngayLe = ca.getNgayLe();
                StringBuilder duLieu = new StringBuilder();
                for (int i = 0; i < gio.length; i++) {
                    if (i > 0) duLieu.append(';');
                    duLieu.append(gio[i]).append(':').append(ngayLe[i]);
                }
                dong.add("CA_DAC_BIET|" + c.getMaCC() + "|" + c.getMaNV() + "|"
                        + c.getThangNam() + "|" + duLieu);
            } else {
                throw new IllegalArgumentException("Khong ho tro kieu cham cong: "
                        + c.getClass().getName());
            }
        }
        java.nio.file.Files.write(tep, dong);
    }

    @Override
    public void docFile(Path tep) throws IOException {
        danhSach.clear();
        for (String dong : java.nio.file.Files.readAllLines(tep)) {
            if (dong.trim().isEmpty()) continue;
            try {
                String[] cot = dong.split("\\|", -1);
                if (cot.length != 5) throw new IOException("Dong du lieu khong hop le: " + dong);
                YearMonth thang = YearMonth.parse(cot[3]);
                if ("HANH_CHINH".equals(cot[0])) {
                    int[] ngay = new int[cot[4].length()];
                    for (int i = 0; i < ngay.length; i++) {
                        if (cot[4].charAt(i) == '1') ngay[i] = i + 1;
                        else if (cot[4].charAt(i) != '0') {
                            throw new IOException("Ngay cong khong hop le: " + dong);
                        }
                    }
                    them(new ChamCongHanhChinh(cot[1], cot[2], thang, ngay));
                } else if ("CA_DAC_BIET".equals(cot[0])) {
                    ChamCongCaDacBiet ca = new ChamCongCaDacBiet(cot[1], cot[2], thang);
                    String[] ngay = cot[4].isEmpty() ? new String[0] : cot[4].split(";");
                    for (int i = 0; i < ngay.length; i++) {
                        String[] giaTri = ngay[i].split(":");
                        if (giaTri.length != 2) throw new IOException("Du lieu ca khong hop le: " + dong);
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
}
