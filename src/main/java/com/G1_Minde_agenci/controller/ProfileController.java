package com.G1_Minde_agenci.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    // Public Route (No Authentication Required)
    @GetMapping("/id")
    public String getAllUsers() {
        return "This is a public route for /users";
    }

    // Example of a Secured Route (Requires Authentication)
    @GetMapping("/secure")
    public String getSecureInfo() {
        return "This is a secure route for /users/secure";
    }
}
