package com.example.a124lttd04_travelappproject.model.hotel;

import android.widget.Button;


public class hotel_ChooseHotel_Hotel_Model {

    private int imgHotel;
    private int imgFiveStar;
    private String tvName;
    private String tvLocation;
    private String tvPrice;
    private Button btnChoose;

    public hotel_ChooseHotel_Hotel_Model(int imgFiveStar, int imgHotel, String tvLocation, String tvName, String tvPrice) {
        this.imgFiveStar = imgFiveStar;
        this.imgHotel = imgHotel;
        this.tvLocation = tvLocation;
        this.tvName = tvName;
        this.tvPrice = tvPrice;
    }

    public Button getBtnChoose() {
        return btnChoose;
    }

    public int getImgFiveStar() {
        return imgFiveStar;
    }

    public int getImgHotel() {
        return imgHotel;
    }

    public String getTvLocation() {
        return tvLocation;
    }

    public String getTvName() {
        return tvName;
    }

    public String getTvPrice() {
        return tvPrice;
    }

    public void setBtnChoose(Button btnChoose) {
        this.btnChoose = btnChoose;
    }

    public void setImgFiveStar(int imgFiveStar) {
        this.imgFiveStar = imgFiveStar;
    }

    public void setImgHotel(int imgHotel) {
        this.imgHotel = imgHotel;
    }

    public void setTvLocation(String tvLocation) {
        this.tvLocation = tvLocation;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public void setTvPrice(String tvPrice) {
        this.tvPrice = tvPrice;
    }
}
