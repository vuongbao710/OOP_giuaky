
package doangiuaky.nhanSu;

import doangiuaky.Enum.LoaiChucVu;
import java.time.LocalDate;

public class NhanVienPartTime extends NhanVien{
    private final int SO_GIO_CONG=4;
    private final double LUONG_MOT_GIO=25000;

    public NhanVienPartTime(String MaNV, String CCCD, String HoTen, String SDT, String MaQuanLyPhuTrach, String MaPhongBan, LocalDate BirthDate, LocalDate NgayVaoLam, String ChucVu) {
        super(MaNV, CCCD, HoTen, SDT, MaQuanLyPhuTrach, MaPhongBan, BirthDate, NgayVaoLam, ChucVu);
    }
    
       public double TinhLuongThucTe(){
           return /*bcc.TongSoNgayCong()**/SO_GIO_CONG*LUONG_MOT_GIO;
       }


    public int getSO_GIO_CONG() {
        return SO_GIO_CONG;
    }

    @Override
    public String toString() {
        return super.toString() + "SO_GIO_CONG=" + SO_GIO_CONG + ", LUONG_MOT_GIO=" + LUONG_MOT_GIO + '}';
    }

   

    public double getLUONG_MOT_GIO() {
        return LUONG_MOT_GIO;
    }
     
    }
