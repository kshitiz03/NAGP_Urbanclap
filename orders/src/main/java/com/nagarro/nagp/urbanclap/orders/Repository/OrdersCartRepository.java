package com.nagarro.nagp.urbanclap.orders.Repository;

import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrdersCartEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersCartRepository {

    public void save(OrdersCartEntity ordersCartEntity) {
    }

    public void deleteByEmailIdServicesSubServices(String mobileNo, String service, String subService) {
    }

    public OrdersCartEntity findByEmailIdAndServicesAndSubServices(String mobileNo, String service, String subService) {
        return null;
    }
}
