package com.project.be.api.repository;

import com.project.be.api.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity,String> {

    AccountEntity findByPhoneNumber(String phoneNumber);
}
