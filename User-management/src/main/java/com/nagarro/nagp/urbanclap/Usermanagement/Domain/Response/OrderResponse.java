package com.nagarro.nagp.urbanclap.Usermanagement.Domain.Response;

import javax.xml.crypto.Data;
import java.util.Date;

public class OrderResponse {

    public String city;

    public String service;

    public Date date;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
