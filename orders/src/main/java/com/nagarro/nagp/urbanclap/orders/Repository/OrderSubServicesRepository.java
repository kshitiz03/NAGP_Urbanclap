package com.nagarro.nagp.urbanclap.orders.Repository;

import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrderSubServices;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderSubServicesRepository {
    public void saveAll(List<OrderSubServices> orderSubServicesList) {
    }

    public List<OrderSubServices> findByorderId(String orderId) {
        return new ArrayList<>();
    }
}
