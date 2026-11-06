
package doangiuaky.TaiKhoan;

import java.util.Scanner;

public class TaiKhoan {
    public enum VaiTro{
        ADMIN,
        QUAN_LY,
        NHAN_VIEN;
    }
    public enum TrangThaiHoatDong{
        BI_KHOA,
        HOAT_DONG;
    }
    
    private String MaTaiKhoan;
    private String TenDangNhap;
    private String MatKhau;
    private VaiTro Role;
    private String MaNV;
    private TrangThaiHoatDong TrangThai;
    private int SoLanSaiMatKhau=5;

    public TaiKhoan(String MaTaiKhoan, String TenDangNhap, String MatKhau, VaiTro Role, String MaNV, TrangThaiHoatDong TrangThai) {
        this.MaTaiKhoan = MaTaiKhoan;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Role = Role;
        this.MaNV = MaNV;
        this.TrangThai = TrangThai;
    }

    public String getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setMaTaiKhoan(String MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public VaiTro getRole() {
        return Role;
    }

    public void setRole(VaiTro Role) {
        this.Role = Role;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public TrangThaiHoatDong getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(TrangThaiHoatDong TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLanSaiMatKhau() {
        return SoLanSaiMatKhau;
    }

    public void setSoLanSaiMatKhau(int SoLanSaiMatKhau) {
        this.SoLanSaiMatKhau = SoLanSaiMatKhau;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "MaTaiKhoan=" + MaTaiKhoan 
                + ", TenDangNhap=" + TenDangNhap + ", MatKhau=" 
                + MatKhau + ", Role=" + Role + ", MaNV=" + MaNV 
                + ", TrangThai=" + TrangThai + ", SoLanSaiMatKhau=" + SoLanSaiMatKhau + '}';
    }
    
    public boolean KiemTraMatKhau(String input){
        return input.equalsIgnoreCase(this.MatKhau);
    }
    public void NhapMatKhau(Scanner sc){
        while(this.SoLanSaiMatKhau>0){
            if(KiemTraMatKhau(sc.nextLine())){
                System.out.println("Đăng nhập thành công!");
                setSoLanSaiMatKhau(5);
                return;
            }
            this.SoLanSaiMatKhau--;
        }
        if(SoLanSaiMatKhau==0){
            setTrangThai(TrangThaiHoatDong.BI_KHOA);
        }
    }
    public void QuenMatKhau(){
        
    }
    public boolean KiemTraTrangThaiHoatDong(){
        if(getTrangThai()==TrangThaiHoatDong.HOAT_DONG){
            return true;
        }
        return false;
    }
    
}
