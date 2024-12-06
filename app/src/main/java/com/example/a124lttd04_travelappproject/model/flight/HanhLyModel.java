package com.example.a124lttd04_travelappproject.model.flight;

public class HanhLyModel {
    private int mahanhly;
    private int khoiluong;
    private float giatien;

    public HanhLyModel() {
    }

    public HanhLyModel(int mahanhly, int khoiluong, float giatien) {
        this.mahanhly = mahanhly;
        this.khoiluong = khoiluong;
        this.giatien = giatien;
    }

    public int getMahanhly() {
        return mahanhly;
    }

    public void setMahanhly(int mahanhly) {
        this.mahanhly = mahanhly;
    }

    public int getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(int khoiluong) {
        this.khoiluong = khoiluong;
    }

    public float getGiatien() {
        return giatien;
    }

    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

}
