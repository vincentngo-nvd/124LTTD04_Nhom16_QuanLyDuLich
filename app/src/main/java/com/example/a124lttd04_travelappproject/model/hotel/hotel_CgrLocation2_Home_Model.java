package com.example.a124lttd04_travelappproject.model.hotel;

import java.util.List;

public class hotel_CgrLocation2_Home_Model {
    private String textView;
    private List<hotel_CgrLocation1_Home_Model> locations;

    public hotel_CgrLocation2_Home_Model(String textView, List<hotel_CgrLocation1_Home_Model> locations) {
        this.locations = locations;
        this.textView = textView;
    }

    public List<hotel_CgrLocation1_Home_Model> getLocations() {
        return locations;
    }

    public String getTextView() {
        return textView;
    }

    public void setLocations(List<hotel_CgrLocation1_Home_Model> locations) {
        this.locations = locations;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }
}
