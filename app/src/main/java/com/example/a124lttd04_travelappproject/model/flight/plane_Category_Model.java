package com.example.a124lttd04_travelappproject.model.flight;

import java.util.List;

public class plane_Category_Model {
    private String nameCategory;
    private List<plane_GiaVeNoiDia_Model> Giave;

    public plane_Category_Model(String nameCategory, List<plane_GiaVeNoiDia_Model> giave) {
        this.nameCategory = nameCategory;
        Giave = giave;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<plane_GiaVeNoiDia_Model> getGiave() {
        return Giave;
    }

    public void setGiave(List<plane_GiaVeNoiDia_Model> giave) {
        Giave = giave;
    }
}
