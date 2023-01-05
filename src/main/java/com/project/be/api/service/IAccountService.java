package com.project.be.api.service;

import com.project.be.api.dto.AccountDTO;
import com.project.be.api.entity.AccountEntity;
import com.project.be.api.entity.UserEntity;
import jakarta.xml.ws.ServiceMode;
import org.springframework.stereotype.Service;

public interface IAccountService extends IGenericService<AccountDTO,Long> {
    /*
    * Check Account by phone number
    * @params phone Number
    *  */
    public AccountEntity getAccountByPhoneNumber(String phoneNumber);
}
