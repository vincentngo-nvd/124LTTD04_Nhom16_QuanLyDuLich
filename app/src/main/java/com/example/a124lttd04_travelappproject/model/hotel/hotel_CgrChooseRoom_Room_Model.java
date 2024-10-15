package com.example.a124lttd04_travelappproject.model.hotel;

public class hotel_CgrChooseRoom_Room_Model {
    private int imgRoom,iconBed,iconWifi,iconAir;
    private String tvNameRoom,tvPerson,tvWifi,tvAir,tvPriceRoom;

    public hotel_CgrChooseRoom_Room_Model(int iconAir, int iconBed, int iconWifi, int imgRoom, String tvAir, String tvNameRoom, String tvPerson, String tvPriceRoom, String tvWifi) {
        this.iconAir = iconAir;
        this.iconBed = iconBed;
        this.iconWifi = iconWifi;
        this.imgRoom = imgRoom;
        this.tvAir = tvAir;
        this.tvNameRoom = tvNameRoom;
        this.tvPerson = tvPerson;
        this.tvPriceRoom = tvPriceRoom;
        this.tvWifi = tvWifi;
    }

    public int getIconAir() {
        return iconAir;
    }

    public int getIconBed() {
        return iconBed;
    }

    public int getIconWifi() {
        return iconWifi;
    }

    public int getImgRoom() {
        return imgRoom;
    }

    public String getTvAir() {
        return tvAir;
    }

    public String getTvNameRoom() {
        return tvNameRoom;
    }

    public String getTvPerson() {
        return tvPerson;
    }

    public String getTvPriceRoom() {
        return tvPriceRoom;
    }

    public String getTvWifi() {
        return tvWifi;
    }

    public void setIconAir(int iconAir) {
        this.iconAir = iconAir;
    }

    public void setIconBed(int iconBed) {
        this.iconBed = iconBed;
    }

    public void setIconWifi(int iconWifi) {
        this.iconWifi = iconWifi;
    }

    public void setImgRoom(int imgRoom) {
        this.imgRoom = imgRoom;
    }

    public void setTvAir(String tvAir) {
        this.tvAir = tvAir;
    }

    public void setTvNameRoom(String tvNameRoom) {
        this.tvNameRoom = tvNameRoom;
    }

    public void setTvPerson(String tvPerson) {
        this.tvPerson = tvPerson;
    }

    public void setTvPriceRoom(String tvPriceRoom) {
        this.tvPriceRoom = tvPriceRoom;
    }

    public void setTvWifi(String tvWifi) {
        this.tvWifi = tvWifi;
    }
}
