package com.nagarro.nagp.urbanclap.orders.services.Impl;

import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrderEntity;
import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrderSubServices;
import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrdersCartEntity;
import com.nagarro.nagp.urbanclap.orders.Domain.Request.PlaceOrderRequest;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.orders.Domain.Response.ServiceOrderHistory;
import com.nagarro.nagp.urbanclap.orders.Domain.ServicesOrder;
import com.nagarro.nagp.urbanclap.orders.MessageBroker.Producer.OrderPlaceProducer;
import com.nagarro.nagp.urbanclap.orders.Repository.OrderSubServicesRepository;
import com.nagarro.nagp.urbanclap.orders.Repository.OrdersCartRepository;
import com.nagarro.nagp.urbanclap.orders.Repository.OrdersRepository;
import com.nagarro.nagp.urbanclap.orders.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersCartRepository ordersCartRepository;

    @Autowired
    OrderPlaceProducer orderPlaceProducer;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderSubServicesRepository orderSubServicesRepository;

    @Override
    public BaseResponse addToCart(String mobileNo, ServicesOrder servicesOrder) {
        OrdersCartEntity ordersCartEntity = new OrdersCartEntity();
        ordersCartEntity = ordersCartRepository.findByEmailIdAndServicesAndSubServices(mobileNo, servicesOrder.getService(), servicesOrder.getSubService());
        if (Objects.nonNull(ordersCartEntity))
            ordersCartEntity.setCount(ordersCartEntity.getCount() + servicesOrder.getCount());
        else {
            ordersCartEntity.setCount(servicesOrder.getCount());
            ordersCartEntity.setCost(servicesOrder.getCost());
            ordersCartEntity.setServices(servicesOrder.getService());
            ordersCartEntity.setSubService(servicesOrder.getSubService());
        }
        ordersCartRepository.save(ordersCartEntity);
        return new BaseResponse("Success", "Added to cart");
    }

    @Override
    public BaseResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(placeOrderRequest, orderEntity);
        String orderId = generateOrderId();
        orderEntity.setOrderId(orderId);
        orderEntity.setCreatedOn(LocalDateTime.now());
        List<OrderSubServices> orderSubServicesList = new ArrayList<>();
        placeOrderRequest.getServicesOrderList().forEach(k -> {
            OrderSubServices orderSubServices = new OrderSubServices();
            BeanUtils.copyProperties(k, orderSubServices);
            orderSubServices.setOrderId(orderId);
            orderSubServicesList.add(orderSubServices);
        });

        assignServiceProvider();

        ordersRepository.save(orderEntity);
        orderSubServicesRepository.saveAll(orderSubServicesList);

        return new BaseResponse("Success", "Order Placed Successfully. We will get back to you with details of service provider");


    }

    private String queueName = "order_place_queue";

    private void assignServiceProvider() {
        orderPlaceProducer.sendMessage(queueName, "Hi,\n There is a new order for you please accept or deny in the app");

    }

    private String generateOrderId() {
        DateFormat zoneFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        zoneFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Kolkata")));
        return zoneFormat.format(getCurrentDateTime());
    }

    private Date getCurrentDateTime() {
        return new Date();
    }

    @Override
    public BaseResponse removeFromCart(String emailId, ServicesOrder servicesOrder) {
        OrdersCartEntity ordersCartEntity = ordersCartRepository.findByEmailIdAndServicesAndSubServices(emailId, servicesOrder.getService(), servicesOrder.getSubService());
        if (Objects.nonNull(ordersCartEntity)) {
            ordersCartRepository.deleteByEmailIdServicesSubServices(emailId, servicesOrder.getService(), servicesOrder.getSubService());
            return new BaseResponse("Success", "Removed from cart");
        }
        return new BaseResponse("Failure", "Not present in cart");
    }

    @Override
    public List<ServiceOrderHistory> getLatestPlacedOrder(String emailId) {
        OrderEntity orderEntity = ordersRepository.findTop1ByEmailIdSortByCreatedOnDSC(emailId);
        List<OrderSubServices> orderSubServices = orderSubServicesRepository.findByorderId(orderEntity.getOrderId());
        List<ServiceOrderHistory> serviceOrderHistories = new ArrayList<>();
        orderSubServices.forEach(k -> {
            ServiceOrderHistory serviceOrderHistory = new ServiceOrderHistory();
            BeanUtils.copyProperties(k, serviceOrderHistory);
            serviceOrderHistories.add(serviceOrderHistory);
        });
        return serviceOrderHistories;
    }

    @Override
    public List<PlaceOrderRequest> getOrderHistory(String emailId) {
        List<OrderEntity> orderEntityList = ordersRepository.findByEmailId(emailId);
        List<PlaceOrderRequest> placeOrderRequestList = new ArrayList<>();
        orderEntityList.forEach(k ->
        {
            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();

            List<OrderSubServices> orderSubServices = orderSubServicesRepository.findByorderId(k.getOrderId());
            List<ServicesOrder> servicesOrderList = new ArrayList<>();
            orderSubServices.forEach(l -> {
                ServicesOrder servicesOrder = new ServicesOrder();
                BeanUtils.copyProperties(l, servicesOrder);
                servicesOrderList.add(servicesOrder);
            });
            BeanUtils.copyProperties(k, placeOrderRequest);
            placeOrderRequest.setServicesOrderList(servicesOrderList);
            placeOrderRequestList.add(placeOrderRequest);
        });
        return placeOrderRequestList;
    }
}
