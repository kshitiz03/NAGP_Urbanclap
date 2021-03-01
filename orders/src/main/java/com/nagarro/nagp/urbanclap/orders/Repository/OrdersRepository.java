package com.nagarro.nagp.urbanclap.orders.Repository;

import com.nagarro.nagp.urbanclap.orders.Domain.Entities.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersRepository {
    public void save(OrderEntity orderEntity) {
    }

    public OrderEntity findTop1ByEmailIdSortByCreatedOnDSC(String emailId) {
        return new OrderEntity();
    }

    public List<OrderEntity> findByEmailId(String mobileNo) {
        return new ArrayList<>();
    }
}
