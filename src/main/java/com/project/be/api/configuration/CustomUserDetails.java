package com.project.be.api.configuration;

import com.project.be.api.entity.AccountEntity;
import com.project.be.api.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final UserEntity userEntity;
    private final AccountEntity accountEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getUUID() {
        return userEntity.getUuid();
    }

    @Override
    public String getPassword() {
        return accountEntity.getPassword();
    }


    @Override
    public String getUsername() {
        return userEntity.getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
