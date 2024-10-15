package com.example.a124lttd04_travelappproject.model.flight;

public class plane_GiaVeQuocTe_Model {
    private int ID;
    private String title;
    private String ngay;
    private String Gia;

    public plane_GiaVeQuocTe_Model(int id, String title, String ngay, String gia) {
        ID = id;
        this.title = title;
        this.ngay = ngay;
        Gia = gia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CharSequence getNgay() {
        return (CharSequence) ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }
}
