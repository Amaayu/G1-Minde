package com.G1_Minde_agenci.controller;

import com.G1_Minde_agenci.entity.User;
import com.G1_Minde_agenci.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;


    /**
     * Endpoint to create a new user.
     * @param newUser The user details to be created.
     * @return Boolean indicating success or failure.
     */
    @PostMapping("/create")
    public Boolean createUser(@RequestBody User newUser) {
        try {
            if (userServices.findByUsername(newUser.getUsername()) != null) {
                throw new RuntimeException("Username already exists");
            }
            return userServices.userSave(newUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Health check endpoint to verify if the server is running.
     * @return Boolean indicating the server status.
     */

    @GetMapping("/health")
    public Boolean serverGood() {
        return true;
    }
}