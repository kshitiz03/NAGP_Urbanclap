package com.nagarro.nagp.urbanclap.orders.Domain.Entities;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderEntity {

    public OrderEntity(String emailId, LocalDateTime createdOn, String address, Date serviceDate, String time, String endUserName, String mobileNo, String orderId, boolean isPaymentDone) {
        this.emailId = emailId;
        this.createdOn = createdOn;
        this.address = address;
        this.serviceDate = serviceDate;
        this.time = time;
        this.endUserName = endUserName;
        this.mobileNo = mobileNo;
        this.orderId = orderId;
        this.isPaymentDone = isPaymentDone;
    }

    private String emailId;

    private LocalDateTime createdOn;

    private String address;

    private Date serviceDate;

    private String time;

    private String endUserName;

    private String mobileNo;

    private String orderId;

    private  boolean isPaymentDone;

    public OrderEntity() {

    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        isPaymentDone = paymentDone;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


}
