
package doangiuaky.TaiKhoan;
import java.util.ArrayList;
public class DanhSachTaiKhoan {
    private ArrayList<TaiKhoan> DanhSachTaiKhoan;

    public DanhSachTaiKhoan(ArrayList<TaiKhoan> DanhSachTaiKhoan) {
        this.DanhSachTaiKhoan = DanhSachTaiKhoan;
    }

    public DanhSachTaiKhoan() {
        this.DanhSachTaiKhoan = new ArrayList<>();
    }

    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        return DanhSachTaiKhoan;
    }

    public void setDanhSachTaiKhoan(ArrayList<TaiKhoan> DanhSachTaiKhoan) {
        this.DanhSachTaiKhoan = DanhSachTaiKhoan;
    }
    
    //public void phanQuyen
    public void them(TaiKhoan tk){
        this.DanhSachTaiKhoan.add(tk);
    }
    public TaiKhoan timKiem(String MaNV){
        for(TaiKhoan tk : this.DanhSachTaiKhoan){
            if(tk.getMaNV().equalsIgnoreCase(MaNV)){
                return tk;
            }
        }
        return null;
    }
    
    
}
