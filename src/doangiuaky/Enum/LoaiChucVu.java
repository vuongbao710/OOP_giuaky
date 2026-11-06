
package doangiuaky.Enum;

    public enum LoaiChucVu {
    GIAM_DOC("giám đốc",30000000),
    QUAN_LY("quản lý",20000000),
    TRUONG_NHOM("trưởng nhóm",10000000),
    NHAN_VIEN("nhân viên",5000000),
    THOI_VU("thời vụ",0);
    
    private String MoTa;
    private double LuongCoBan;

    private LoaiChucVu(String MoTa, double LuongCoBan) {
        this.MoTa = MoTa;
        this.LuongCoBan=LuongCoBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }
    
    
    public static LoaiChucVu NhanDien(String input){
        for(LoaiChucVu cv : LoaiChucVu.values()){
            if(cv.getMoTa().equalsIgnoreCase(input)){
                return cv;
            }
        }
        return null;
    }
            
    
}

