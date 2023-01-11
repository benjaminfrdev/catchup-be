package com.project.be.api.service;

import com.project.be.api.dto.AccountDTO;
import com.project.be.api.entity.AccountEntity;

import java.util.Optional;

public interface IAccountService extends IGenericService<AccountDTO,Long> {
    /*
    * Check Account by phone number
    * @params phone Number
    *  */
    public Optional<AccountEntity> getAccountByPhoneNumber(String phoneNumber);
}
