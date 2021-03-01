package com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response;

import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.ServiceProviderModel;

import java.util.List;

public class ServiceProviderCityDetails {

    List<ServiceProviderModel> serviceProviderModelList;

    public List<ServiceProviderModel> getServiceProviderModelList() {
        return serviceProviderModelList;
    }

    public void setServiceProviderModelList(List<ServiceProviderModel> serviceProviderModelList) {
        this.serviceProviderModelList = serviceProviderModelList;
    }
}
