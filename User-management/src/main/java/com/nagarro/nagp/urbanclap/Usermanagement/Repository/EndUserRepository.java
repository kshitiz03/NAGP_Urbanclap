package com.nagarro.nagp.urbanclap.Usermanagement.Repository;

import com.nagarro.nagp.urbanclap.Usermanagement.Domain.EndUserEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class EndUserRepository {


    public EndUserEntity getEndUserByMobileNo(String mobileNo){
        return new EndUserEntity("kr@gmail.com","UBLOCK","kr","8910510005","1234",LocalDateTime.parse("18-MAR-20 07.51.59.000000000 AM"));
    }

    public void save(EndUserEntity endUserEntity) {
    }
}
