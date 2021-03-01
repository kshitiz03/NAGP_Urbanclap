package com.nagarro.nagp.urbanclap.Usermanagement.services.Impl;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response.BaseResponse;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.Request.SignupRequest;
import com.nagarro.nagp.urbanclap.Usermanagement.Domain.ServiceProviderEntity;
import com.nagarro.nagp.urbanclap.Usermanagement.MessageBroker.Producer.ProviderAssignment;
import com.nagarro.nagp.urbanclap.Usermanagement.Repository.ServiceProviderRepository;
import com.nagarro.nagp.urbanclap.Usermanagement.services.ServiceProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;
    @Autowired
    ProviderAssignment providerAssignment;

    @Override
    public BaseResponse getRegistrationResponse(SignupRequest signupRequest) {
        ServiceProviderEntity serviceProviderEntity = new ServiceProviderEntity();
        BeanUtils.copyProperties(signupRequest,serviceProviderEntity);
        serviceProviderRepository.save(serviceProviderEntity);
        return new BaseResponse("Success", "We will get back to you");
    }

    @Override
    public List<ServiceProviderEntity> getProviderDetailsByService(String subService) {
        return serviceProviderRepository.getAllByServiceSortByRatingDesc(subService);
    }

    @Override
    public List<ServiceProviderEntity> getProviderDetailsByCityService(String city, String service) {
        return serviceProviderRepository.findByJobAndAddress(service,city);
    }

    private String queueName = "order_accept_notification_queue";
    @Override
    public BaseResponse acceptOrDenyOrder(String emailId, Boolean orderResponse) {
        if(orderResponse) {
            ServiceProviderEntity serviceProviderEntity = serviceProviderRepository.findByEmailId(emailId);

            providerAssignment.sendMessage(queueName,"Your order has been accepted by "+ serviceProviderEntity.toString());
            return new BaseResponse("Success", "You have got the order please reach on time");
        }
        else
            return new BaseResponse("Success", "Looking for a different order for you");

    }
}
