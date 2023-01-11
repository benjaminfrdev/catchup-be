package com.project.be.api.controller;

import com.project.be.api.configuration.CustomUserDetails;
import com.project.be.api.configuration.jwtconfig.JwtTokenProvider;
import com.project.be.api.dto.AccountDTO;
import com.project.be.api.dto.LoginRequest;
import com.project.be.api.dto.LoginResponse;
import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.AccountEntity;
import com.project.be.api.exception.BadRequest;
import com.project.be.api.exception.Conflict;
import com.project.be.api.service.IAccountService;
import com.project.be.api.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    /* Constructor Injection */
    private final IAccountService accountService;
    private final IUserService userService;
    private final PasswordEncoder pwEncoderConfig;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenicationManager;


    /*
    * Register Func
    * @params : AccountEntity , BindingResult
    * return user just register
    * */
    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> generateUser(@RequestBody @Validated AccountDTO account, BindingResult bdResult) {

        if (bdResult.hasErrors()) {
            throw new BadRequest();
        }

        if(this.accountService.getAccountByPhoneNumber(account.getPhoneNumber()).isPresent()) {
                throw new Conflict();
        }

        String userUuid = UUID.randomUUID().toString();
        account.setPassword(this.pwEncoderConfig.encode(account.getPassword()));
        UserDTO userDTO = UserDTO.builder()
                                 .uuid(userUuid)
                                 .phoneNumber(account.getPhoneNumber())
                                 .name(account.getPhoneNumber())
                                 .build();
        this.accountService.insert(account);
        this.userService.insert(userDTO);

        return Collections.singletonMap("message", "ok.");
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Xác thực từ username và password.
        Authentication authentication = authenicationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhoneNumber(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.

        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
}
