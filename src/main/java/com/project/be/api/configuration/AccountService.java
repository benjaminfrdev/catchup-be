package com.project.be.api.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AccountService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
//    private IUserRepository userRepository;
//    public UserService(IUserRepository userRepository){
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
