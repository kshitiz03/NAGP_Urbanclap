package com.nagarro.nagp.urbanclap.Usermanagement.services;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.LoginRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.SignupResponse;

public interface EndUserService {
    BaseResponse getSendOTPResponse(String email);

    SignupResponse getSignUpResponse(LoginRequest loginRequest);
}
