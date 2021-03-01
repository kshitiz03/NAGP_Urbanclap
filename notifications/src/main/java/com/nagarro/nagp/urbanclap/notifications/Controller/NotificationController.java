package com.nagarro.nagp.urbanclap.notifications.Controller;

import com.nagarro.nagp.urbanclap.notifications.Domain.BaseResponse;
import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OTPEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OrderEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

   /* @PostMapping(path = "/order-decision")
    public ResponseEntity<BaseResponse> sendOTPEmail(@RequestBody OrderEmailRequest orderEmailRequest){

        notificationService.sendOrderDecisionEmail(orderEmailRequest);
        return ResponseEntity.ok(new BaseResponse("Success","OTP sent successfully"));
    }*/

    @PostMapping(path = "/send-otp")
    public ResponseEntity<BaseResponse> sendOTPEmail(@RequestBody OTPEmailRequest otpEmailRequest){

        notificationService.sendOTPEmail(otpEmailRequest);
        return ResponseEntity.ok(new BaseResponse("Success","OTP sent successfully"));
    }

}
