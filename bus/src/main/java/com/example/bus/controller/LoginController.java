package com.example.bus.controller;

import com.example.bus.entity.User;
import com.example.bus.api.request.login.LoginRequest;
import com.example.bus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/UserLogin")
    public String loginDetail(@RequestBody LoginRequest loginRequest)
    {
        User user = loginRepository.login(loginRequest.getEmail(), loginRequest.getPhoneNumber());
        if(user!=null)
        {
            return "Welcome";
        }
        return "Wrong Credentials";

    }

}
