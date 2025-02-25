package com.G1_Minde_agenci.services;

import com.G1_Minde_agenci.Repository.UserRepo;
import com.G1_Minde_agenci.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Saves a user to the database after encoding the password.
     * @param customer The user entity to be saved.
     * @return Boolean indicating success or failure.
     */
    @Transactional
    public void customerSave(User customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        userRepository.save(customer);
        System.out.println(customer);
    }

    /**
     * Finds a user by their username.
     * @param username The username to search for.
     * @return The user entity if found, otherwise null.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
