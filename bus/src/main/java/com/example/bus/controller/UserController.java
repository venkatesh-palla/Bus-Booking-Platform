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


    /**
     * Endpoint to create a new user.
     *
     * @param userRequest The request body containing user details.
     * @return UserResponse containing details of the created user.
     */
    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }


    /**
     * Endpoint to update an existing user.
     *
     * @param userRequest The request body containing updated user details.
     * @return UserResponse containing details of the updated user.
     */
    @PutMapping("/update")
    public UserResponse update(@RequestBody UserRequest userRequest) {
        return userService.update(userRequest);
    }


    /**
     * Endpoint to delete a user by user ID.
     *
     * @param userId The ID of the user to delete.
     */
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }


    /**
     * Endpoint to retrieve details of all users.
     *
     * @return List of UserResponse containing details of all users.
     */
    @GetMapping("/getData")
    public List<UserResponse> get() {
        return userService.get();
    }

}
