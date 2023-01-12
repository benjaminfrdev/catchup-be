package com.project.be.api.configuration;

import com.project.be.api.entity.AccountEntity;
import com.project.be.api.entity.UserEntity;
import com.project.be.api.repository.IAccountRepository;
import com.project.be.api.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthenService implements UserDetailsService {
    private final IAccountRepository accountRepository;
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get from account table
        Optional<AccountEntity> account = accountRepository.findByPhoneNumber(username);
        if (account.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }else{
            Optional<UserEntity> user = userRepository.findByPhoneNumber(username);
            return new CustomUserDetails(user.get(),account.get());
        }
    }

}
