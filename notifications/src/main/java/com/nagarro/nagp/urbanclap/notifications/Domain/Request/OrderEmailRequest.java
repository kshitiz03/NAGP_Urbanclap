package com.nagarro.nagp.urbanclap.notifications.Domain.Request;

import javax.validation.constraints.Email;
import java.util.List;

public class OrderEmailRequest {

    List<String> emailIdList;

    public List<String> getEmailIdList() {
        return emailIdList;
    }

    public void setEmailIdList(List<String> emailIdList) {
        this.emailIdList = emailIdList;
    }
}
