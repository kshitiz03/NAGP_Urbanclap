package com.nagarro.nagp.urbanclap.servicesmanagement.Constants;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public interface ServiceConstants {

    ImmutableList<String> CITY_LIST = ImmutableList.copyOf(Arrays.asList("Kolkata","Delhi","Gurgaon","Noida"));

    ImmutableMap<String, List<String>> SERVICE_MAP = ImmutableMap.<String, List<String>>builder()
            .put("Salon for Men",Arrays.asList("50% off","20% off"))
            .put("Plumbers",Arrays.asList("60% off","30% off"))
            .put("Electricians",Arrays.asList("20% off"))
            .put("Appliance Repair",Arrays.asList("Buy 1 Get 1 free","30% off"))
            .build();

    ImmutableMap<String, List<String>> SERVICE_MAP1 = ImmutableMap.<String, List<String>>builder()
            .put("Salon for Men",Arrays.asList("50% off","20% off"))
            .put("Plumbers",Arrays.asList("60% off","30% off"))
            .put("Appliance Repair",Arrays.asList("Buy 1 Get 1 free","30% off"))
            .build();

    ImmutableMap<String, List<String>> SERVICE_MAP2 = ImmutableMap.<String, List<String>>builder()
            .put("Plumbers",Arrays.asList("60% off","30% off"))
            .put("Salon for Women",Arrays.asList("20% off"))
            .put("Appliance Repair",Arrays.asList("Buy 1 Get 1 free","30% off"))
            .build();

    ImmutableMap<String, ImmutableMap<String, List<String>>> CITY_SERVICE_MAP = ImmutableMap.<String, ImmutableMap<String, List<String>>>builder()
            .put("Kolkata",SERVICE_MAP)
            .put("Noida",SERVICE_MAP1)
            .put("Gurgaon",SERVICE_MAP2)
            .build();

    ImmutableMap<String, String> SUB_SERVICE_MAP = ImmutableMap.<String,String>builder()
            .put("Water Leakage","299")
            .build();

    ImmutableMap<String, String> SUB_SERVICE_MAP1 = ImmutableMap.<String,String>builder()
            .put("Waxing and threading","299")
            .build();
    ImmutableMap<String, String> SUB_SERVICE_MAP2 = ImmutableMap.<String,String>builder()
            .put("Microwave","299")
            .build();
    ImmutableMap<String, String> SUB_SERVICE_MAP3 = ImmutableMap.<String,String>builder()
            .put("Manicure","299")
            .build();
    ImmutableMap<String, String> SUB_SERVICE_MAP4= ImmutableMap.<String,String>builder()
            .put("TV","299")
            .build();

    ImmutableMap<String, List<ImmutableMap<String,String>>>SUB_SERVICES_ALL_MAP = ImmutableMap.<String, List<ImmutableMap<String,String>>>builder()
            .put("Plumbers",Arrays.asList(SUB_SERVICE_MAP,SUB_SERVICE_MAP1))
            .put("Salon for Women",Arrays.asList(SUB_SERVICE_MAP2,SUB_SERVICE_MAP3))
            .put("Appliance Repair",Arrays.asList(SUB_SERVICE_MAP4))
            .build();

    String WORKING = "working";
    String FAQ = "faq";
    String CUSTOMER_REVIEWS = "customer reviews";
    String BLOGS = "blogs";
    String ABOUT = "about";
    ImmutableMap<String, String> SERVICE_BASIC_MAP = ImmutableMap.<String,String>builder()
            .put(WORKING,"data")
            .put(FAQ,"faq")
            .put(CUSTOMER_REVIEWS,"reviews")
            .put(BLOGS,"blogs")
            .put(ABOUT,"about")
            .build();



}
