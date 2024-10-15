package com.example.a124lttd04_travelappproject.model.flight;

import java.util.List;

public class plane_CategoryQuocte_Model {
    private String nameCategory;
    private List<plane_GiaVeQuocTe_Model> Giave;

    public plane_CategoryQuocte_Model(String nameCategory, List<plane_GiaVeQuocTe_Model> giave) {
        this.nameCategory = nameCategory;
        Giave = giave;
    }
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<plane_GiaVeQuocTe_Model> getGiave() {
        return Giave;
    }

    public void setGiave(List<plane_GiaVeQuocTe_Model> giave) {
        Giave = giave;
    }
}
