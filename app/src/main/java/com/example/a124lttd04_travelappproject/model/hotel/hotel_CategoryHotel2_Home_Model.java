package com.example.a124lttd04_travelappproject.model.hotel;

public class hotel_CategoryHotel2_Home_Model {
    private int resoureImage;
    private  String nameHotel;
    private int iconStar;
    private String price;

    public hotel_CategoryHotel2_Home_Model(int resoureImage, String nameHotel, String price , int iconStar) {
        this.iconStar = iconStar;
        this.nameHotel = nameHotel;
        this.price = price;
        this.resoureImage = resoureImage;
    }

    public int getIconStar() {
        return iconStar;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public String getPrice() {
        return price;
    }

    public int getResoureImage() {
        return resoureImage;
    }

}
