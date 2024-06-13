package com.example.bus.controller;

import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;
import com.example.bus.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest)
    {
        return userService.create(userRequest);
    }

    @PutMapping("/update")
    public UserResponse update(@RequestBody UserRequest userRequest)
    {
        return userService.create(userRequest);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId)
    {
       userService.delete(userId);
    }

    @GetMapping("/getData")
    public List<UserResponse> get()
    {
        return userService.get();
    }


}
