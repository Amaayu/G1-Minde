package com.G1_Minde_agenci.services;

import com.G1_Minde_agenci.Repository.UserRepo;
import com.G1_Minde_agenci.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepository;


    /**
     * Saves a user to the database.
     * @param user The user entity to be saved.
     * @return Boolean indicating success or failure.
     */
    public Boolean userSave(User user) {
        userRepository.save(user);
        return true;
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