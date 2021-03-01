package com.nagarro.nagp.urbanclap.servicesmanagement.services.Impl;

import com.google.common.collect.ImmutableMap;
import com.nagarro.nagp.urbanclap.servicesmanagement.Constants.ServiceConstants;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Request.ServiceCityRequest;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceInfoResponse;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceListResponse;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceProviderCityDetails;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.ServiceProviderModel;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.ServiceProviderInfo;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.SubServices;
import com.nagarro.nagp.urbanclap.servicesmanagement.Repository.CatalogRepository;
import com.nagarro.nagp.urbanclap.servicesmanagement.services.CatalogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    CatalogRepository catalogRepository;


    @Override
    public List<String> getAllCities() {
        return catalogRepository.getCityList();
    }

    @Override
    public List<ServiceListResponse> getServicesByCity(String cityName) {
        Map<String, ImmutableMap<String, List<String>>> servicesMap = catalogRepository.getServicesBycity(cityName);
        Map<String, List<String>> serviceByCityMap = servicesMap.get(cityName);
        List<ServiceListResponse> serviceListResponseList=  new ArrayList<>();
        serviceByCityMap.forEach((k, v) -> {
            serviceListResponseList.add(new ServiceListResponse(k,v));
        });
        return serviceListResponseList;
    }

    @Override
    public ServiceInfoResponse getServiceInfo(ServiceCityRequest serviceCityRequest) {
        Map<String,String> serviceBasicDetail = catalogRepository.getServiceBasicDetails(serviceCityRequest.getService());
        ServiceInfoResponse serviceInfoResponse = new ServiceInfoResponse();
        serviceInfoResponse.setAboutService(serviceBasicDetail.get(ServiceConstants.ABOUT));
        serviceInfoResponse.setBlogs(serviceBasicDetail.get(ServiceConstants.BLOGS));
        serviceInfoResponse.setCustomerReviews(serviceBasicDetail.get(ServiceConstants.CUSTOMER_REVIEWS));
        serviceInfoResponse.setWorking(serviceBasicDetail.get(ServiceConstants.WORKING));
        serviceInfoResponse.setFaq(serviceBasicDetail.get(ServiceConstants.FAQ));
        List<SubServices> subServices=new ArrayList<>();
        catalogRepository.getSubServices().get(serviceCityRequest.getService()).forEach(k -> k.forEach((r,m) -> subServices.add(new SubServices(r,m))));
        serviceInfoResponse.setSubServices(subServices);
        //get provider details
        serviceInfoResponse.setServiceProviderInfo(getServiceProviderDetails(serviceCityRequest));
        return serviceInfoResponse;
    }

    private List<ServiceProviderInfo> getServiceProviderDetails(ServiceCityRequest serviceCityRequest) {

        URI uri = URI.create("http://ums-service/provider/"+serviceCityRequest.getCity()+"/" + serviceCityRequest.getService());
        WebClient.RequestBodySpec resp = webClientBuilder.build().post().uri(uri);
        WebClient.ResponseSpec resc = resp.retrieve();

        ServiceProviderCityDetails serviceProviderCityDetails =  resc.bodyToMono(ServiceProviderCityDetails.class).block();
        List<ServiceProviderInfo> serviceProviderInfoList= new ArrayList<>();
        serviceProviderCityDetails.getServiceProviderModelList().forEach(k->
        {
            ServiceProviderInfo serviceProviderInfo = new ServiceProviderInfo();
            BeanUtils.copyProperties(k,serviceProviderInfo);
            serviceProviderInfoList.add(serviceProviderInfo);

        });
    return serviceProviderInfoList;
    }
}
