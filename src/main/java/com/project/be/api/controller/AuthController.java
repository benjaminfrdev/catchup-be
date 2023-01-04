package com.project.be.api.controller;

import com.project.be.api.configuration.jwtconfig.JwtTokenProvider;
import com.project.be.api.dto.UserDTO;
import com.project.be.api.entity.AccountEntity;
import com.project.be.api.exception.BadRequest;
import com.project.be.api.exception.Conflict;
import com.project.be.api.service.IAccountService;
import com.project.be.api.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {
    /* Constructor Injection */
    private final IAccountService accountService;
    private final IUserService userService;
    private final PasswordEncoder pwEncoderConfig;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(IAccountService accountService, IUserService userService, PasswordEncoder pwEncoderConfig, JwtTokenProvider jwtTokenProvider){
        this.accountService = accountService;
        this.userService = userService;
        this.pwEncoderConfig = pwEncoderConfig;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /*
    * Register Func
    * @params : AccountEntity , BindingResult
    * return user just register
    * */
    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> generateUser(@RequestBody @Validated AccountEntity account, BindingResult bdResult) {

        if (bdResult.hasErrors()) {
            throw new BadRequest();
        }

        if(this.accountService.getAccountByPhoneNumber(account.getPhoneNumber()) != null) {
                throw new Conflict();
        }

        String userUuid = UUID.randomUUID().toString();
        account.setPassword(this.pwEncoderConfig.encode(account.getPassword()));
        UserDTO userDTO = UserDTO.builder()
                                 .uuid(userUuid)
                                 .phoneNumber(account.getPhoneNumber())
                                 .name(account.getPhoneNumber())
                                 .build();
        this.
        this.userService.insert(userDTO);

//        Long userId = this.userService.generateUser(user).getId();
//
//        UserKey userKey = new UserKey();
//        userKey.setTokenType("Bearer");
//        userKey.setToken(this.jwtService.generateJwt(userId, 365, userUuid));
//        userKey.setRefreshToken(this.jwtService.generateJwt(userId, 365, userUuid));
//        userKey.setExpiresAt(Util.calculateDate());
//        userKey.setUserId(userId);

        this.userService.generateUserKey(userKey);
        return Collections.singletonMap("message", "ok.");
    }

}
