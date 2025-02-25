package com.G1_Minde_agenci.services;

import com.G1_Minde_agenci.Repository.UserRepo;
import com.G1_Minde_agenci.configuration.CustomUserDetails;
import com.G1_Minde_agenci.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomerUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        } else {
            return new CustomUserDetails(user);

        }
    }
}