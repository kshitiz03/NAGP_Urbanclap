package com.nagarro.nagp.urbanclap.servicesmanagement.Controller;

import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Request.ServiceCityRequest;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Request.SubServicesRequest;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceInfoResponse;
import com.nagarro.nagp.urbanclap.servicesmanagement.Domain.Response.ServiceListResponse;
import com.nagarro.nagp.urbanclap.servicesmanagement.services.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {

    public static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    CatalogService catalogService;
    @GetMapping(path="/services/{city}")
    public ResponseEntity<List<ServiceListResponse>> getServicesByCity(
        @PathVariable(required = true) String cityName){
        return new ResponseEntity<>(catalogService.getServicesByCity(cityName), HttpStatus.OK);
    }

    @PostMapping(path="/service-info")
    public ResponseEntity<ServiceInfoResponse> getInfoByService(
            @RequestBody ServiceCityRequest serviceCityRequest){

        return new ResponseEntity<>(catalogService.getServiceInfo(serviceCityRequest), HttpStatus.OK);

    }
/*    @PostMapping(path="/sub-service/cost")
    public ResponseEntity<ServiceInfoResponse> getSubServiceCost(
            @RequestBody SubServicesRequest serviceCityRequest){
        return ResponseEntity.ok(catalogService.getSubServiceInfo(serviceCityRequest));
    }*/

    @GetMapping(path="/cities")
    public ResponseEntity<List<String>> getServiceableCities(){
        return new ResponseEntity<>(catalogService.getAllCities(), HttpStatus.OK);

    }
}
