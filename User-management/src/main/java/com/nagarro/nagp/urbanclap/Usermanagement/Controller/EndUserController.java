package com.nagarro.nagp.urbanclap.Usermanagement.Controller;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.LoginRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.SignupResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.services.EndUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/end-user")
public class EndUserController {
    public static final Logger logger = LoggerFactory.getLogger(EndUserController.class);

    @Autowired
    EndUserService endUserService;

    @GetMapping(path = "/send-otp/{email}")
    public ResponseEntity<BaseResponse> getSendOTPEndUser(@PathVariable(required = true) String email){
        BaseResponse baseResponse = endUserService.getSendOTPResponse(email);
        return ResponseEntity.ok(baseResponse);

    }

    @PostMapping(path = "/signup")
    public ResponseEntity<SignupResponse> getSignUpEndUser(@RequestBody LoginRequest loginRequest){

        SignupResponse signupResponse= endUserService.getSignUpResponse(loginRequest);
        return "Success".equals(signupResponse.getBaseResponse().getStatus()) ? ResponseEntity.ok(signupResponse)
                : new ResponseEntity<>(signupResponse, HttpStatus.UNAUTHORIZED);

    }
}
