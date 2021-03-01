package com.nagarro.nagp.urbanclap.notifications.Service;

import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OTPEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OrderEmailRequest;


public interface NotificationService {
    public void sendOrderDecisionEmail(OrderEmailRequest orderEmailRequest,String subject, String text);

    public void sendOTPEmail(OTPEmailRequest otpEmailRequest);
}
