package com.nagarro.nagp.urbanclap.notifications.Domain.Request;

public class OTPEmailRequest {

    private String otp;

    private String emailId;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
