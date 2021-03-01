package com.nagarro.nagp.urbanclap.notifications.Service.Impl;

import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OTPEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OrderEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendOrderDecisionEmail(OrderEmailRequest orderEmailRequest, String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        String[] emailIdList = orderEmailRequest.getEmailIdList().toArray(new String[0]);

        msg.setTo(emailIdList);

        msg.setSubject("Accept/deny order");
        msg.setText("Hi \n We have a job service for you. Please go to the app to check order details and confirm about your service");
        javaMailSender.send(msg);
    }

    @Override
    public void sendOTPEmail(OTPEmailRequest otpEmailRequest) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(otpEmailRequest.getEmailId());
        msg.setSubject("Urbanclap OTP");
        msg.setText("Hi \n OTP for login is" + otpEmailRequest.getOtp());
        javaMailSender.send(msg);
    }
}
