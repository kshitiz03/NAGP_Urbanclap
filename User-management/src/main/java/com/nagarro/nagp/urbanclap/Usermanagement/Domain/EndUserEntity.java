package com.nagarro.nagp.urbanclap.Usermanagement.Domain;

import java.time.LocalDateTime;

public class EndUserEntity {
    public EndUserEntity(String email, String status, String userName, String mobileNo, String otp, LocalDateTime otpCreatedOn) {
        this.email = email;
        this.status = status;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.otp = otp;
        this.otpCreatedOn = otpCreatedOn;
    }

    private String email;

    private String status;

    private String userName;

    private String mobileNo;

    private String otp;

    protected LocalDateTime otpCreatedOn;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtpCreatedOn() {
        return otpCreatedOn;
    }

    public void setOtpCreatedOn(LocalDateTime otpCreatedOn) {
        this.otpCreatedOn = otpCreatedOn;
    }
}
