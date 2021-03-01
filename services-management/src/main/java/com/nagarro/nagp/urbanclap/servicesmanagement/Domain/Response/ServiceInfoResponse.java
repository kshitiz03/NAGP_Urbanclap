package com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response;

import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.ServiceProviderInfo;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.SubServices;

import java.util.List;

public class ServiceInfoResponse {

    private String working;

    private String faq;

    private String aboutService;

    private String customerReviews;

    private String blogs;

    private List<ServiceProviderInfo> serviceProviderInfo;

    private List<SubServices> subServices;

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }

    public String getAboutService() {
        return aboutService;
    }

    public void setAboutService(String aboutService) {
        this.aboutService = aboutService;
    }

    public String getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(String customerReviews) {
        this.customerReviews = customerReviews;
    }

    public String getBlogs() {
        return blogs;
    }

    public void setBlogs(String blogs) {
        this.blogs = blogs;
    }

    public List<ServiceProviderInfo> getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    public void setServiceProviderInfo(List<ServiceProviderInfo> serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }

    public List<SubServices> getSubServices() {
        return subServices;
    }

    public void setSubServices(List<SubServices> subServices) {
        this.subServices = subServices;
    }
}
