package com.project.be.api.controller;

import com.project.be.api.entity.AccountEntity;
import com.project.be.api.exception.BadRequest;
import com.project.be.api.exception.Conflict;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {

    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> generateUser(@RequestBody @Validated AccountEntity account, BindingResult bdResult) {

        if (bdResult.hasErrors()) {
            throw new BadRequest();
        }


        if (this.userService.getUserByEmail(user.getEmail()) != null) {
            throw new Conflict();
        }

        String userUuid = UUID.randomUUID().toString();

        user.setPassword(this.pwEncoderConfig.passwordEncoder().encode(user.getPassword()));
        user.setUuid(userUuid);

        Long userId = this.userService.generateUser(user).getId();

        UserKey userKey = new UserKey();
        userKey.setTokenType("Bearer");
        userKey.setToken(this.jwtService.generateJwt(userId, 365, userUuid));
        userKey.setRefreshToken(this.jwtService.generateJwt(userId, 365, userUuid));
        userKey.setExpiresAt(Util.calculateDate());
        userKey.setUserId(userId);

        this.userService.generateUserKey(userKey);
        return Collections.singletonMap("message", "ok.");
    }

}
