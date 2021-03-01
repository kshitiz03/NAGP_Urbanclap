package com.nagarro.nagp.urbanclap.Usermanagement.Repository;

import com.google.inject.internal.cglib.core.$ReflectUtils;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.ServiceProviderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceProviderRepository {

    public void save(ServiceProviderEntity serviceProviderEntity){
        return;
    }

    public List<ServiceProviderEntity> getAllByServiceSortByRatingDesc(String subService) {

        List<ServiceProviderEntity> serviceProviderEntities = new ArrayList<>();
        serviceProviderEntities.add(new ServiceProviderEntity(1,"kr","12345679","kr@gmail.com","plumber","kolkata","4","excellent"));
        serviceProviderEntities.add(new ServiceProviderEntity(2,"kr","12345679","kr@gmail.com","plumber","kolkata","4","excellent"));
        return serviceProviderEntities;
    }

    public List<ServiceProviderEntity> findByJobAndAddress(String service, String city) {
        List<ServiceProviderEntity> serviceProviderEntities = new ArrayList<>();
        serviceProviderEntities.add(new ServiceProviderEntity(1,"kr","12345679","kr@gmail.com","plumber","kolkata","4","excellent"));
        serviceProviderEntities.add(new ServiceProviderEntity(2,"kr","12345679","kr@gmail.com","plumber","kolkata","4","excellent"));
        return serviceProviderEntities;
    }


    public ServiceProviderEntity findByEmailId(String emailId) {
        return new ServiceProviderEntity(1,"kr","12345679","kr@gmail.com","plumber","kolkata","4","excellent");
    }
}
