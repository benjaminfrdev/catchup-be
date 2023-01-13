package com.project.be.api.service;

import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.UserEntity;

import java.util.List;

public interface IUserService extends IGenericService<UserDTO,Long> {


    /**
     * Get user by uuid
     */
     UserDTO getByUUID(String uuid);


    /**
     * Search function for finding user
     * @param keyword
     * @return
     */
    List<UserDTO> findByKeyWord(String keyword);
}
