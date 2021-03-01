package com.nagarro.nagp.urbanclap.Usermanagement.services.Impl;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.EndUserEntity;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.LoginRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.SignupResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Repository.EndUserRepository;
import com.nagarro.nagp.urbanclap.Usermanagement.Utils.SMSServiceUtil;
import com.nagarro.nagp.urbanclap.Usermanagement.Utils.TokenUtils;
import com.nagarro.nagp.urbanclap.Usermanagement.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Service
public class EndUserServiceImpl implements EndUserService {

    @Autowired
    EndUserRepository endUserRepository;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    SMSServiceUtil smsServiceUtil;

    @Override
    public BaseResponse getSendOTPResponse(String email) {
        String otp = generateOTP();
        EndUserEntity endUserEntity=endUserRepository.getEndUserByMobileNo(email);
        if(Objects.nonNull(endUserEntity)) {
            if (getMinutes(endUserEntity.getOtpCreatedOn(), LocalDateTime.now()) < 2)
                return new BaseResponse("Failure", "otp cannot be sent again within 2 mins");
        }
        endUserEntity.setOtp(otp);
        endUserEntity.setEmail(email);
        endUserEntity.setStatus("UNBLOCK");
        endUserEntity.setOtpCreatedOn(LocalDateTime.now());
        endUserRepository.save(endUserEntity);
        smsServiceUtil.sendOTP(email,otp);

        return new BaseResponse("Success","OTP sent successfully");

    }

    @Override
    public SignupResponse getSignUpResponse(LoginRequest loginRequest) {
        EndUserEntity endUserEntity=endUserRepository.getEndUserByMobileNo(loginRequest.getEmail());
        if(endUserEntity.getOtp().equals(loginRequest.getOtp())){
            BaseResponse baseResponse=new BaseResponse("Success","Login Successful");
            return new SignupResponse(baseResponse,tokenUtils.generateToken());

        }
        else {
            BaseResponse baseResponse = new BaseResponse("Failure", "Login Failed");
            return new SignupResponse(baseResponse,null);
        }
    }

    public static long getMinutes(LocalDateTime startInclusive, LocalDateTime endExclusive) {
        return  Duration.between(startInclusive, endExclusive).toMinutes();
    }

    public String generateOTP() {
        return String.format("%04d", new Random().nextInt(10000));
    }
}
