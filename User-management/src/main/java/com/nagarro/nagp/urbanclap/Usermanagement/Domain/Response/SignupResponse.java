package com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response;

public class SignupResponse {
    public SignupResponse(BaseResponse baseResponse, String token) {
        this.baseResponse = baseResponse;
        this.token = token;
    }

    private BaseResponse baseResponse;

    private  String token;

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
