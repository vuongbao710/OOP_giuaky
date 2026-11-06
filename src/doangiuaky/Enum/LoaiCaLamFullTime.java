
package doangiuaky.Enum;

import java.time.LocalTime;

public enum LoaiCaLamFullTime {
    SANG("ca sáng",LocalTime.of(6, 0),LocalTime.of(14, 0)),
    CHIEU("ca chiều",LocalTime.of(14, 0),LocalTime.of(22, 0)),
    TOI("ca tối",LocalTime.of(22, 0),LocalTime.of(6, 0));
    
    private String MoTa;
    private LocalTime GioVao;
    private LocalTime GioRa;

    private LoaiCaLamFullTime(String MoTa, LocalTime GioVao, LocalTime GioRa) {
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
    public static LoaiCaLamFullTime NhanDien(String MoTa){
        for(LoaiCaLamFullTime ft : LoaiCaLamFullTime.values()){
            if(ft.getMoTa().equalsIgnoreCase(MoTa)){
                return ft;
            }
        }
        return null;
    }
}
