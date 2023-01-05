package com.project.be.api.configuration;

import com.project.be.api.entity.AccountEntity;
import com.project.be.api.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails {
//    private AccountEntity accountEntity;
//
//    public CustomUserDetails(AccountEntity accountEntity){
//        this.accountEntity = accountEntity;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    public String getUserId() {
//        return userEntity.getUuid();
//    }
//    @Override
//    public String getPassword() {
//        return userEntity.get();
//    }
//
//    @Override
//    public String getUsername() {
//        return userEntity.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }


}
