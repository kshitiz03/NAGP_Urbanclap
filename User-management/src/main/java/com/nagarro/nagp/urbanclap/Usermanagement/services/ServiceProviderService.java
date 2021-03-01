package com.nagarro.nagp.urbanclap.Usermanagement.services;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.SignupRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.ServiceProviderEntity;

import java.util.List;

public interface ServiceProviderService {
    BaseResponse getRegistrationResponse(SignupRequest signupRequest);

    List<ServiceProviderEntity> getProviderDetailsByService(String subService);

    List<ServiceProviderEntity> getProviderDetailsByCityService(String city, String service);

    BaseResponse acceptOrDenyOrder(String emailId, Boolean orderResponse);
}
