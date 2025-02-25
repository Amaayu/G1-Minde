package com.G1_Minde_agenci.controller;

import com.G1_Minde_agenci.dto.LoginDto;
import com.G1_Minde_agenci.entity.User;
import com.G1_Minde_agenci.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Endpoint to create a new user.
     * Saves plain text password (Not recommended for production).
     * @param newUser The user details to be created.
     * @return Boolean indicating success or failure.
     */
    @PostMapping("/create")
    public Boolean createUser(@RequestBody User newUser) {
        try {
            if (userServices.findByUsername(newUser.getUsername()) != null) {
                throw new RuntimeException("Username already exists");
            }
            // Plain text password save (No encoding)
             userServices.customerSave(newUser);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simple login route to check username and password.
     * Plain text password comparison.
     * @param loginDto The user login details (username and password).
     * @return Map containing success message if credentials are correct.
        */

    // Login Routes or EndPoints
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        // Logic to authenticate user
        try {
            User user = userServices.findByUsername(loginDto.getUsername());
            if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Login successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
