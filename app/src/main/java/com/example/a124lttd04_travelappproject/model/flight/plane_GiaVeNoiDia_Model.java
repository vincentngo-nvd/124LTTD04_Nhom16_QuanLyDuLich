package com.example.a124lttd04_travelappproject.model.flight;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class plane_GiaVeNoiDia_Model {
    @SerializedName("_ID")
        private int mavemaybay;
        private String tenvemaybay;
        private String noidi;
        private String noiden;

        private Date thoigianbay;

        private String tenghe;

        private String giave;
        private String hinhanh;
    public plane_GiaVeNoiDia_Model() {
    }

    public plane_GiaVeNoiDia_Model(int mavemaybay, String tenvemaybay, String noidi, String noiden, Date thoigianbay, String tenghe, String giave, String hinhanh) {
        this.mavemaybay = mavemaybay;
        this.tenvemaybay = tenvemaybay;
        this.noidi = noidi;
        this.noiden = noiden;
        this.thoigianbay = thoigianbay;
        this.tenghe = tenghe;
        this.giave = giave;
        this.hinhanh = hinhanh;
    }

    public int getMavemaybay() {
        return mavemaybay;
    }

    public void setMavemaybay(int mavemaybay) {
        this.mavemaybay = mavemaybay;
    }

    public String getTenvemaybay() {
        return tenvemaybay;
    }

    public void setTenvemaybay(String tenvemaybay) {
        this.tenvemaybay = tenvemaybay;
    }

    public String getNoidi() {
        return noidi;
    }

    public void setNoidi(String noidi) {
        this.noidi = noidi;
    }

    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public Date getThoigianbay() {
        return thoigianbay;
    }

    public void setThoigianbay(Date thoigianbay) {
        this.thoigianbay = thoigianbay;
    }

    public String getTenghe() {
        return tenghe;
    }

    public void setTenghe(String tenghe) {
        this.tenghe = tenghe;
    }

    public String getGiave() {
        return giave;
    }

    public void setGiave(String giave) {
        this.giave = giave;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @Override
    public String toString() {
        return "plane_GiaVeNoiDia_Model{" +
                "mavemaybay=" + mavemaybay +
                ", tenvemaybay='" + tenvemaybay + '\'' +
                ", noidi='" + noidi + '\'' +
                ", noiden='" + noiden + '\'' +
                ", thoigianbay=" + thoigianbay +
                ", tenghe='" + tenghe + '\'' +
                ", giave='" + giave + '\'' +
                ", hinhanh='" + hinhanh + '\'' +
                '}';
    }
}
