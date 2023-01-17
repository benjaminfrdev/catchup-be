package com.project.be.api.service.impl;

import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.UserEntity;
import com.project.be.api.exception.InternalServerError;
import com.project.be.api.mapper.IUserMapper;
import com.project.be.api.mapper.impl.UserMapper;
import com.project.be.api.repository.IUserRepository;
import com.project.be.api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
//    Logger
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    public UserService(IUserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAll() {
        try{
            return !this.userRepository.findAll().isEmpty() ? this.userMapper.mapToListDTO(this.userRepository.findAll()) : null;
        }catch (Exception e){
            throw new InternalServerError();
        }
    }

    /**
     *  Insert new new User in Database
     * @param userDTO
     */
    @Override
    public void insert(UserDTO userDTO) {
        try{
            logger.info("Start insert new user into Database",userDTO);
            UserEntity userEntity = userMapper.mapToEntity(userDTO);
            userRepository.save(userEntity);
            logger.info("End insert new user into Database",userDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new InternalServerError();
        }
    }

    @Override
    public void insertBulk(List<UserDTO> userDTOS) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public UserDTO getById(Long id) {
        return null;
    }


    @Override
    public UserDTO getByUUID(String uuid) {
        return this.userRepository.findById(uuid).isPresent()
                ? this.userMapper.mapToDTO(this.userRepository.findById(uuid).get()) : null;
    }

    @Override
    public List<UserDTO> findByKeyWord(String keyword) {
        return null;
    }
}
