package com.example.a124lttd04_travelappproject.model.hotel;

import java.util.List;

public class hotel_CategoryHotel1_Home_Model {
    private String nameCategory;
    private List<hotel_CategoryHotel2_Home_Model> cardviews;

    public hotel_CategoryHotel1_Home_Model(String nameCategory, List<hotel_CategoryHotel2_Home_Model> cardviews ) {
        this.cardviews = cardviews;
        this.nameCategory = nameCategory;
    }

    public List<hotel_CategoryHotel2_Home_Model> getCardviews() {
        return cardviews;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setCardviews(List<hotel_CategoryHotel2_Home_Model> cardviews) {
        this.cardviews = cardviews;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
