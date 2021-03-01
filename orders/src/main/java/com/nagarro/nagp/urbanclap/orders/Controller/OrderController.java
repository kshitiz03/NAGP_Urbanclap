package com.nagarro.nagp.urbanclap.orders.Controller;

import com.nagarro.nagp.urbanclap.orders.Domain.Request.PlaceOrderRequest;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.ServiceOrderHistory;
import com.nagarro.nagp.urbanclap.orders.Domain.ServicesOrder;
import com.nagarro.nagp.urbanclap.orders.services.OrderService;
import org.bouncycastle.jcajce.provider.symmetric.HC256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @PostMapping(path = "/place-order")
    public ResponseEntity<BaseResponse> getOrderPlaced(@RequestBody PlaceOrderRequest placeOrderRequest) {
    BaseResponse baseResponse = orderService.placeOrder(placeOrderRequest);

    return ResponseEntity.ok(baseResponse);
    }

    @PostMapping(path = "/add-cart/{emailId}")
    public ResponseEntity<BaseResponse> saveToCart(@PathVariable String emailId, @RequestBody ServicesOrder servicesOrder) {
        BaseResponse baseResponse = orderService.addToCart(emailId,servicesOrder);
        return ResponseEntity.ok(baseResponse);

    }

    @PostMapping(path = "/remove-cart/{emailId}")
    public ResponseEntity<BaseResponse> removeFromCart(@PathVariable String emailId, @RequestBody ServicesOrder servicesOrder) {

        BaseResponse baseResponse = orderService.removeFromCart(emailId,servicesOrder);
        return ResponseEntity.ok(baseResponse);

    }

    @PostMapping(path = "/order-summary/{email-id}")
    public ResponseEntity<List<ServiceOrderHistory>> getOrderPlaced(@PathVariable String emailId) {

        List<ServiceOrderHistory> baseResponse = orderService.getLatestPlacedOrder(emailId);
        return ResponseEntity.ok(baseResponse);

    }

    @GetMapping(path = "/order-history/{email-id}")
    public ResponseEntity<List<PlaceOrderRequest>> getOrderHistory(@PathVariable String emailId) {

        List<PlaceOrderRequest> baseResponse = orderService.getOrderHistory(emailId);
        return ResponseEntity.ok(baseResponse);

    }

}
