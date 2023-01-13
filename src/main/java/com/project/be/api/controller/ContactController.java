package com.project.be.api.controller;

import com.project.be.api.configuration.jwtconfig.JwtTokenProvider;
import com.project.be.api.dto.UserDTO;
import com.project.be.api.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IUserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getListUserContact(){

        return null;
    }
}
