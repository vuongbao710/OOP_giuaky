package doangiuaky.Enum;

public enum LoaiViTri {
    // --- KINH DOANH (7 vị trí) ---
    NHAN_VIEN_KINH_DOANH("VT01", "Nhân viên kinh doanh", "Kinh doanh"),
    NHAN_VIEN_KINH_DOANH_THI_TRUONG("VT02", "Nhân viên kinh doanh thị trường", "Kinh doanh"),
    CHUYEN_VIEN_PHAT_TRIEN_DOI_TAC("VT03", "Chuyên viên phát triển đối tác", "Kinh doanh"),
    CHUYEN_VIEN_KINH_DOANH_ONLINE("VT04", "Chuyên viên kinh doanh online", "Kinh doanh"),
    NHAN_VIEN_HO_TRO_KINH_DOANH("VT05", "Nhân viên hỗ trợ kinh doanh", "Kinh doanh"),
    CHUYEN_VIEN_PHAN_TICH_DOANH_SO("VT06", "Chuyên viên phân tích doanh số", "Kinh doanh"),
    CONG_TAC_VIEN_BAN_HANG("VT07", "Cộng tác viên bán hàng", "Kinh doanh"),

    // --- SẢN XUẤT (8 vị trí) ---
    CONG_NHAN_VAN_HANH_MAY("VT08", "Công nhân vận hành máy", "Sản xuất"),
    CONG_NHAN_LAP_RAP("VT09", "Công nhân lắp ráp", "Sản xuất"),
    KY_THUAT_VIEN_BAO_TRI_MAY_MOC("VT10", "Kỹ thuật viên bảo trì máy móc", "Sản xuất"),
    NHAN_VIEN_KIEM_TRA_CHAT_LUONG("VT11", "Nhân viên kiểm tra chất lượng", "Sản xuất"),
    KY_SU_QUY_TRINH_SAN_XUAT("VT12", "Kỹ sư quy trình sản xuất", "Sản xuất"),
    NHAN_VIEN_AN_TOAN_LAO_DONG("VT13", "Nhân viên an toàn lao động", "Sản xuất"),
    NHAN_VIEN_KE_HOACH_SAN_XUAT("VT14", "Nhân viên kế hoạch sản xuất", "Sản xuất"),
    CONG_NHAN_THOI_VU("VT15", "Công nhân thời vụ", "Sản xuất"),

    // --- LOGISTIC (8 vị trí) ---
    NHAN_VIEN_KHO("VT16", "Nhân viên kho", "Logistic"),
    NHAN_VIEN_DIEU_PHOI_VAN_CHUYEN("VT17", "Nhân viên điều phối vận chuyển", "Logistic"),
    TAI_XE_GIAO_HANG("VT18", "Tài xế giao hàng", "Logistic"),
    NHAN_VIEN_XUAT_NHAP_HANG("VT19", "Nhân viên xuất nhập hàng", "Logistic"),
    NHAN_VIEN_QUAN_LY_TON_KHO("VT20", "Nhân viên quản lý tồn kho", "Logistic"),
    NHAN_VIEN_XU_LY_DON_HANG("VT21", "Nhân viên xử lý đơn hàng", "Logistic"),
    CHUYEN_VIEN_THU_MUA("VT22", "Chuyên viên thu mua", "Logistic"),
    NHAN_VIEN_DONG_GOI("VT23", "Nhân viên đóng gói", "Logistic"),

    // --- NHÂN SỰ (7 vị trí) ---
    CHUYEN_VIEN_TUYEN_DUNG("VT24", "Chuyên viên tuyển dụng", "Nhân sự"),
    CHUYEN_VIEN_TIEN_LUONG_VA_PHUC_LOI("VT25", "Chuyên viên tiền lương và phúc lợi (C&B)", "Nhân sự"),
    CHUYEN_VIEN_DAO_TAO("VT26", "Chuyên viên đào tạo", "Nhân sự"),
    CHUYEN_VIEN_QUAN_HE_LAO_DONG("VT27", "Chuyên viên quan hệ lao động", "Nhân sự"),
    NHAN_VIEN_HANH_CHINH_NHAN_SU("VT28", "Nhân viên hành chính nhân sự", "Nhân sự"),
    CHUYEN_VIEN_DANH_GIA_KPI("VT29", "Chuyên viên đánh giá KPI", "Nhân sự"),
    THUC_TAP_SINH_NHAN_SU("VT30", "Thực tập sinh nhân sự", "Nhân sự"),

    // --- CHĂM SÓC KHÁCH HÀNG (7 vị trí) ---
    NHAN_VIEN_TONG_DAI("VT31", "Nhân viên tổng đài", "Chăm sóc khách hàng"),
    NHAN_VIEN_CSKH_QUA_CHAT_EMAIL("VT32", "Nhân viên CSKH qua chat / email", "Chăm sóc khách hàng"),
    NHAN_VIEN_XU_LY_KHIEU_NAI("VT33", "Nhân viên xử lý khiếu nại", "Chăm sóc khách hàng"),
    NHAN_VIEN_CHAM_SOC_KHACH_HANG_THAN_THIET("VT34", "Nhân viên chăm sóc khách hàng thân thiết", "Chăm sóc khách hàng"),
    NHAN_VIEN_HO_TRO_KY_THUAT("VT35", "Nhân viên hỗ trợ kỹ thuật", "Chăm sóc khách hàng"),
    NHAN_VIEN_CSKH_CA_TOI("VT36", "Nhân viên CSKH ca tối", "Chăm sóc khách hàng"),
    NHAN_VIEN_KHAO_SAT_KHACH_HANG("VT37", "Nhân viên khảo sát khách hàng", "Chăm sóc khách hàng"),

    // --- MARKETING (7 vị trí) ---
    CHUYEN_VIEN_DIGITAL_MARKETING("VT38", "Chuyên viên digital marketing", "Marketing"),
    CHUYEN_VIEN_SEO_SEM("VT39", "Chuyên viên SEO / SEM", "Marketing"),
    CHUYEN_VIEN_CONTENT("VT40", "Chuyên viên content", "Marketing"),
    THIET_KE_DO_HOA("VT41", "Thiết kế đồ họa", "Marketing"),
    CHUYEN_VIEN_QUAN_LY_MANG_XA_HOI("VT42", "Chuyên viên quản lý mạng xã hội", "Marketing"),
    CHUYEN_VIEN_NGHIEN_CUU_THI_TRUONG("VT43", "Chuyên viên nghiên cứu thị trường", "Marketing"),
    THUC_TAP_SINH_CONTENT("VT44", "Thực tập sinh content", "Marketing"),

    // --- KẾ TOÁN (7 vị trí) ---
    KE_TOAN_TONG_HOP("VT45", "Kế toán tổng hợp", "Kế toán"),
    KE_TOAN_THANH_TOAN("VT46", "Kế toán thanh toán", "Kế toán"),
    KE_TOAN_CONG_NO("VT47", "Kế toán công nợ", "Kế toán"),
    KE_TOAN_KHO("VT48", "Kế toán kho", "Kế toán"),
    KE_TOAN_THUE("VT49", "Kế toán thuế", "Kế toán"),
    KE_TOAN_GIA_THANH("VT50", "Kế toán giá thành", "Kế toán"),
    NHAN_VIEN_NHAP_LIEU_KE_TOAN("VT51", "Nhân viên nhập liệu kế toán", "Kế toán");

    private String MaViTri;
    private String MoTa;
    private String PhongBan;

    private LoaiViTri(String MaViTri, String MoTa, String PhongBan) {
        this.MaViTri = MaViTri;
        this.MoTa = MoTa;
        this.PhongBan = PhongBan;
    }

    public String getMaViTri() { return MaViTri; }

    public void setMaViTri(String MaViTri) { this.MaViTri = MaViTri; }

    public String getMoTa() { return MoTa; }

    public void setMoTa(String MoTa) { this.MoTa = MoTa; }

    public String getPhongBan() { return PhongBan; }

    public void setPhongBan(String PhongBan) { this.PhongBan = PhongBan; }

    public static LoaiViTri NhanDien(String input) {
        if (input == null) return null;
        for (LoaiViTri vt : LoaiViTri.values()) {
            if (vt.getMaViTri().equalsIgnoreCase(input.trim()) || vt.getMoTa().equalsIgnoreCase(input.trim())) {
                return vt;
            }
        }
        return null;
    }
}
