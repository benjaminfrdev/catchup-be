package com.project.be.api.controller;

import com.project.be.api.configuration.jwtconfig.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider tokenProvider;

    @GetMapping(value = "/hello")
    public String hello(){
        return "hlelloo";
    }
}
