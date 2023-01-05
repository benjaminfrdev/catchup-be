package com.project.be.api.configuration;

import com.project.be.api.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthenService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
//    private final IUserRepository userRepository;
//    private
//    public AccountService(IUserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByUsername(username);
//        if(user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomUserDetails(user);
//
//    }
//    public UserDetails loadUserById(Long id) {
//        Optional<UserEntity> user = userRepository.findById(id);
//        if(user != null) {
//            return new CustomUserDetails(user.get());
//        }
//        return null;
//    }
}
