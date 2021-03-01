package com.nagarro.nagp.urbanclap.servicesmanagement.services;

import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Request.ServiceCityRequest;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Request.SubServicesRequest;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceInfoResponse;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceListResponse;

import java.util.List;

public interface CatalogService {
    public List<String> getAllCities();

    public List<ServiceListResponse> getServicesByCity(String cityName);

    ServiceInfoResponse getServiceInfo(ServiceCityRequest serviceCityRequest);

   // Object getSubServiceInfo(SubServicesRequest serviceCityRequest);
}
