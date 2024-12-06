package com.example.a124lttd04_travelappproject.model.tour;

public class tour_ChuyenBay_Model {
    private int hinhAnh;
    private String tenChuyenBay;
    private String diaDiem;
    private String thoiGian;
    private String gia;

    public tour_ChuyenBay_Model(int hinhAnh, String tenChuyenBay, String diaDiem, String thoiGian, String gia) {
        this.hinhAnh = hinhAnh;
        this.tenChuyenBay = tenChuyenBay;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.gia = gia;
    }

    public tour_ChuyenBay_Model() {

    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenChuyenBay() {
        return tenChuyenBay;
    }

    public void setTenChuyenBay(String tenChuyenBay) {
        this.tenChuyenBay = tenChuyenBay;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
