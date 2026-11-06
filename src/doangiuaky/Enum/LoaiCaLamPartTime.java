
package doangiuaky.Enum;

import java.time.LocalTime;
public enum LoaiCaLamPartTime {
    SANG("ca sáng",LocalTime.of(8, 0),LocalTime.of(12, 0)),
    CHIEU("ca chiều",LocalTime.of(13, 0),LocalTime.of(17, 0)),
    TOI("ca tối",LocalTime.of(18, 0),LocalTime.of(22, 0));
    
    private String MoTa;
    private LocalTime GioVao;
    private LocalTime GioRa;

    private LoaiCaLamPartTime(String MoTa, LocalTime GioVao, LocalTime GioRa) {
        this.MoTa = MoTa;
        this.GioVao = GioVao;
        this.GioRa = GioRa;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public LocalTime getGioVao() {
        return GioVao;
    }

    public void setGioVao(LocalTime GioVao) {
        this.GioVao = GioVao;
    }

    public LocalTime getGioRa() {
        return GioRa;
    }

    public void setGioRa(LocalTime GioRa) {
        this.GioRa = GioRa;
    }
    public static LoaiCaLamPartTime NhanDien(String MoTa){
        for(LoaiCaLamPartTime pt : LoaiCaLamPartTime.values()){
            if(pt.getMoTa().equalsIgnoreCase(MoTa)){
                return pt;
            }
        }
        return null;
    }
    
}
