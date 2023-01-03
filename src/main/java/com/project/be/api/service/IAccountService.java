package com.project.be.api.service;

import com.project.be.api.entity.UserEntity;
import jakarta.xml.ws.ServiceMode;
import org.springframework.stereotype.Service;

public interface IAccountService extends IGenericService<UserEntity,Long> {
    /*
    * Check Account by phone number
    * @params phone Number
    *  */
    public String getAccountByPhoneNumber(String phoneNumber);

}
