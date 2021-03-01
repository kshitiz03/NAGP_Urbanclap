package com.nagarro.nagp.urbanclap.servicesmanagement.Repository;

import com.google.common.collect.ImmutableMap;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceInfoResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.nagarro.nagp.urbanclap.servicesmanagement.Constants.ServiceConstants.*;

@Repository
public class CatalogRepository {


    public Map<String, ImmutableMap<String, List<String>>> getServicesBycity(String city){
        Map<String, ImmutableMap<String, List<String>>> map = CITY_SERVICE_MAP;
        return map;
    }

    public List<String> getCityList() {
        return CITY_LIST;
    }

    public Map<String, String> getServiceBasicDetails(String service) {
        return SERVICE_BASIC_MAP;
    }

    public ImmutableMap<String, List<ImmutableMap<String,String>>> getSubServices() {
        return SUB_SERVICES_ALL_MAP;
    }
}
