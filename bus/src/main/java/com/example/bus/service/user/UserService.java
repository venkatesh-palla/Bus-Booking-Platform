package com.example.bus.service.user;

import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;

import java.util.List;


public interface UserService {

    /**
     * Creates a new user based on the provided user request.
     *
     * @param userRequest The user request containing user details.
     * @return UserResponse containing the created user details.
     */
    public UserResponse create(UserRequest userRequest);


    /**
     * Updates an existing user based on the provided user request.
     *
     * @param userRequest The user request containing updated user details.
     * @return UserResponse containing the updated user details.
     */
    public UserResponse update(UserRequest userRequest);



    /**
     * Deletes a user identified by the given user ID.
     *
     * @param userId The ID of the user to delete.
     */
    public void delete(Long userId);


    /**
     * Retrieves a list of all users.
     *
     * @return List of UserResponse objects representing all users.
     */
    public List<UserResponse> get();

    /**
     * Retrives data by userId
     * @param userId
     * @return user data
     */
    public UserResponse getDataByUserId(Long userId);

}
