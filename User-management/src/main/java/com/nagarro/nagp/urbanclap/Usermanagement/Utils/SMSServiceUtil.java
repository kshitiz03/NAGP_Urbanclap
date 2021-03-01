package com.nagarro.nagp.urbanclap.Usermanagement.Utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
public class SMSServiceUtil {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void sendOTP(String mobileNo, String otp) {

        URI uri = URI.create("http://notification-service/send-otp/");
        WebClient.RequestBodySpec resp = webClientBuilder.build().post().uri(uri);
        WebClient.ResponseSpec resc = resp.retrieve();

       resc.bodyToMono(BaseResponse.class).block();
    }
}
