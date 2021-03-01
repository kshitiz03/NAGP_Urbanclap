package com.nagarro.nagp.urbanclap.servicesmanagement.Domain;

public class ServiceProviderInfo {

    private String name;

    private String address;

    private String rating;

    private String famousComment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFamousComment() {
        return famousComment;
    }

    public void setFamousComment(String famousComment) {
        this.famousComment = famousComment;
    }
}
