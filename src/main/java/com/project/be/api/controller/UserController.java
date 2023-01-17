package com.project.be.api.controller;

import com.project.be.api.configuration.jwtconfig.JwtTokenProvider;
import com.project.be.api.dto.UserDTO;
import com.project.be.api.service.IUserService;
import com.project.be.api.service.impl.UserService;
import com.project.be.api.util.Validation;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider tokenProvider;
    private final IUserService userService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> lists = userService.getAll();
        return lists != null ? ResponseEntity.ok(lists) : null;
    }


}
