package com.project.be.api.mapper.impl;


import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.UserEntity;
import com.project.be.api.mapper.IUserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements IUserMapper {
    @Override
    public UserDTO mapToDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .name(userEntity.getName())
                .uuid(userEntity.getUuid())
                .phoneNumber(userEntity.getPhoneNumber())
                .status(userEntity.getStatus())
                .avatar(userEntity.getAvatar())
                .build();

    }

    @Override
    public UserEntity mapToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .name(userDTO.getName())
                .uuid(userDTO.getUuid())
                .phoneNumber(userDTO.getPhoneNumber())
                .status(userDTO.getStatus())
                .avatar(userDTO.getAvatar())
                .build();
    }



    @Override
    public List<UserDTO> mapToListDTO(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> mapToListEntity(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}


