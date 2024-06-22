package com.example.bus.controller;

import com.example.bus.entity.User;
import com.example.bus.api.request.login.LoginRequest;
import com.example.bus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling user login related endpoints.
 */
@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    /**
     * Endpoint to authenticate user login credentials.
     *
     * @param loginRequest The request body containing user login details (email and phoneNumber).
     * @return String message indicating successful login ("Welcome") or invalid credentials ("Wrong Credentials").
     */
    @PostMapping("/UserLogin")
 //   @Operation(summary = "User login",
//            description = "Authenticates user login credentials and returns a welcome message upon successful login or an error message for invalid credentials.")
    public String loginDetail(@RequestBody LoginRequest loginRequest) {
        // Call repository method to find user by email and phone number
        User user = loginRepository.login(loginRequest.getEmail(), loginRequest.getPhoneNumber());

        // Check if user exists
        if (user != null) {
            return "Welcome"; // Return welcome message if user exists
        }

        return "Wrong Credentials"; // Return error message for invalid credentials
    }
}
