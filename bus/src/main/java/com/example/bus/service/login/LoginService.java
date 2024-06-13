package com.example.bus.service.login;

import com.example.bus.api.request.login.LoginRequest;
import com.example.bus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public void loginDetail(LoginRequest loginRequest)
    {
       loginRepository.login(loginRequest.getEmail(), loginRequest.getPhoneNumber());
    }


}
