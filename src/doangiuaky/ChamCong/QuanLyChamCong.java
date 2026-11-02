package doangiuaky.ChamCong;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface QuanLyChamCong<T extends ChamCong> {
    void them(T chamCong);
    boolean xoa(String maCC);
    T timChinhXac(String maCC);
    List<T> timGanDung(String tuKhoa);
    void ghiFile(Path tep) throws IOException;
    void docFile(Path tep) throws IOException;
}
