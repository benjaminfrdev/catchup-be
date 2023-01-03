package com.project.be.api.service.impl;

import com.project.be.api.entity.UserEntity;
import com.project.be.api.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Override
    public String getAccountByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public void insert(UserEntity userEntity) {

    }

    @Override
    public void insertBulk(List<UserEntity> userEntities) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public UserEntity getById(Long id) {
        return null;
    }
}
