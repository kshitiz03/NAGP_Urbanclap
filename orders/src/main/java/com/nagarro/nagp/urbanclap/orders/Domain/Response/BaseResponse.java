package com.nagarro.nagp.urbanclap.orders.Domain.Response;

public class BaseResponse {

    protected String status;

    protected String message;

    public BaseResponse() {

    }

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
