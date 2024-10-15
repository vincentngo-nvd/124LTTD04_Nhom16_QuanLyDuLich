package com.example.a124lttd04_travelappproject.model.hotel;

public class hotel_CgrLocation1_Home_Model {
    private int imgLocation;
    private  String nameLocation;
    private String sum;

    public hotel_CgrLocation1_Home_Model(int imgLocation, String nameLocation, String sum) {
        this.imgLocation = imgLocation;
        this.nameLocation = nameLocation;
        this.sum = sum;
    }

    public int getImgLocation() {
        return imgLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public String getSum() {
        return sum;
    }

    public void setImgLocation(int imgLocation) {
        this.imgLocation = imgLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
