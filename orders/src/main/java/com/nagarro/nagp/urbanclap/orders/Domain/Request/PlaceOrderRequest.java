package com.nagarro.nagp.urbanclap.orders.Domain.Request;

import com.nagarro.nagp.urbanclap.orders.Domain.ServicesOrder;

import java.util.Date;
import java.util.List;

public class PlaceOrderRequest {

    private List<ServicesOrder> servicesOrderList;

    private String emailId;

    private String address;

    private  String mobileNo;

    private Date serviceDate;

    private String time;

    private String endUserName;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<ServicesOrder> getServicesOrderList() {
        return servicesOrderList;
    }

    public void setServicesOrderList(List<ServicesOrder> servicesOrderList) {
        this.servicesOrderList = servicesOrderList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }
}
