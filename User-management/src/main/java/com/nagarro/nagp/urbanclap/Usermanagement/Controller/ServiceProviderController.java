package com.nagarro.nagp.urbanclap.Usermanagement.Controller;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.SignupRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.OrderResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.ServiceProviderEntity;
import com.nagarro.nagp.urbanclap.Usermanagement.services.ServiceProviderService;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/provider")
public class ServiceProviderController {

    public static final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

    @Autowired
    ServiceProviderService serviceProviderService;

    @PostMapping(path = "/signup")
    public ResponseEntity<BaseResponse> getSignUpEndUser(@RequestBody SignupRequest signupRequest){

        BaseResponse signupResponse= serviceProviderService.getRegistrationResponse(signupRequest);
        return "Success".equals(signupResponse.getStatus()) ? ResponseEntity.ok(signupResponse)
                : new ResponseEntity<>(signupResponse, HttpStatus.UNAUTHORIZED);

    }

    @PostMapping(path = "/details")
    public ResponseEntity<List<ServiceProviderEntity>> getProviderDetails(@RequestParam String subService) {
        return ResponseEntity.ok(serviceProviderService.getProviderDetailsByService(subService));
    }

    @PostMapping(path = "/provider/{city}/{service}")
    public ResponseEntity<List<ServiceProviderEntity>> getProviderDetailsByCityService(@PathVariable String city,@PathVariable String service) {
        return ResponseEntity.ok(serviceProviderService.getProviderDetailsByCityService(city,service));
    }

    @PostMapping(path = "/order-response/{emailId}/{isAccepted}")
    public ResponseEntity<BaseResponse> getProviderResponseByOrder(@PathVariable String emailId,@PathVariable Boolean isAccepted) {
        return ResponseEntity.ok(serviceProviderService.acceptOrDenyOrder(emailId,isAccepted));
    }

}
