package com.project.be.api.mapper.impl;

import com.project.be.api.dto.AccountDTO;
import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.AccountEntity;
import com.project.be.api.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AccountMapper implements IGenericMapper<AccountDTO, AccountEntity> {

    @Override
    public AccountDTO mapToDTO(AccountEntity accountEntity) {
        return AccountDTO.builder()
                .phoneNumber(accountEntity.getPhoneNumber())
                .password(accountEntity.getPassword())
                .build();

    }

    @Override
    public AccountEntity mapToEntity(AccountDTO accountDTO) {
        return AccountEntity.builder()
                .phoneNumber(accountDTO.getPhoneNumber())
                .password(accountDTO.getPassword())
                .build();
    }

    @Override
    public List<AccountDTO> mapToListDTO(List<AccountEntity> accountEntities) {
        if(accountEntities.size() > 0){
            return accountEntities.stream().map(this::mapToDTO)
                                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<AccountEntity> mapToListEntity(List<AccountDTO> accountDTOS) {
        if(accountDTOS.size() > 0){
            return accountDTOS.stream().map(this::mapToEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
