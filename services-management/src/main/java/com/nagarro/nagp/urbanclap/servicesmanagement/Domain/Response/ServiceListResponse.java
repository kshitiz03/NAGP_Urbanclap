package com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class ServiceListResponse {
    public ServiceListResponse(String serviceName, List<String> offers) {
        this.serviceName = serviceName;
        this.offers = offers;
    }

    private String serviceName;

    private List<String> offers;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }
}
