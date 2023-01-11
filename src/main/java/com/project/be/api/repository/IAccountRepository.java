package com.project.be.api.repository;

import com.project.be.api.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountEntity,String> {

    Optional<AccountEntity> findByPhoneNumber(String phoneNumber);
}
