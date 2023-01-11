package com.project.be.api.repository;

import com.project.be.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
