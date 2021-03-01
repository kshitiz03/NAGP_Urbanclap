package com.nagarro.nagp.urbanclap.orders.services;

import com.nagarro.nagp.urbanclap.orders.Domain.Request.PlaceOrderRequest;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.ServiceOrderHistory;
import com.nagarro.nagp.urbanclap.orders.Domain.ServicesOrder;

import java.util.List;

public interface OrderService {
    public BaseResponse addToCart(String mobileNo, ServicesOrder servicesOrder);
    public BaseResponse placeOrder(PlaceOrderRequest placeOrderRequest);

    BaseResponse removeFromCart(String emailId, ServicesOrder servicesOrder);

    List<ServiceOrderHistory> getLatestPlacedOrder(String emailId);

    List<PlaceOrderRequest> getOrderHistory(String emailId);
}
