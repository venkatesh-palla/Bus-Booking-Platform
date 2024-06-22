package com.example.bus.controller;

import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;
import com.example.bus.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create a new user",
            description = "Creates a new user with the provided details.")
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
    @Operation(summary = "Update an existing user",
            description = "Updates an existing user with the provided details.")
    public UserResponse update(@RequestBody UserRequest userRequest) {
        return userService.update(userRequest);
    }


    /**
     * Endpoint to delete a user by user ID.
     *
     * @param userId The ID of the user to delete.
     */
    @DeleteMapping("/delete/{userId}")
    @Operation(summary = "Delete a user",
            description = "Deletes a user by their ID.")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }


    /**
     * Endpoint to retrieve details of all users.
     *
     * @return List of UserResponse containing details of all users.
     */
    @GetMapping("/getData")
    @Operation(summary = "Get all users",
            description = "Retrieves details of all users.")
    public List<UserResponse> get() {
        return userService.get();
    }

}
