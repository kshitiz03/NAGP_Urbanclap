package com.nagarro.nagp.urbanclap.Usermanagement.Domain;

public class ServiceProviderEntity {
    public ServiceProviderEntity(long id, String name, String mobileNo, String email, String job, String address, String rating, String famousComment) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.job = job;
        this.address = address;
        this.rating = rating;
        this.famousComment = famousComment;
    }

    private long id;

    private String name;

    private String mobileNo;

    private String email;

    private String job;

    private String address;

    private String rating;

    private String famousComment;



    public ServiceProviderEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
