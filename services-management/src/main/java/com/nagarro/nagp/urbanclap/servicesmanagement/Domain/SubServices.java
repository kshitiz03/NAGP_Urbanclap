package com.nagarro.nagp.urbanclap.servicesmanagement.Domain;

public class SubServices {
    public SubServices(String subServcie, String cost) {
        this.subServcie = subServcie;
        this.cost = cost;
    }

    private String subServcie;

    private String cost;

    public String getSubServcie() {
        return subServcie;
    }

    public void setSubServcie(String subServcie) {
        this.subServcie = subServcie;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
