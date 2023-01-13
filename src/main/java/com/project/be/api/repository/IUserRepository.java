package com.project.be.api.repository;

import com.project.be.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
// find User by phoneNumber
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);

//    findUserByKeyword
    @Query("SELECT u FROM user u WHERE u.phoneNumber LIKE %:keyword%")
    List<UserEntity> findUserByKeyword(String keyword);

}
