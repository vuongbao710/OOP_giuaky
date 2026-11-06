
package doangiuaky.Interface;

public interface DanhSach<T> {
    public void them(T item);
    public void xoa(T item);
    public void xuat();
    public T timKiem(String item);
}
