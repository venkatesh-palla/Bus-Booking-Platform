package com.example.bus.service.user;

import com.example.bus.entity.User;
import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;
import com.example.bus.exception.UserNotFoundException;
import com.example.bus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    /**
     * Creates a new user based on the provided user request.
     *
     * @param userRequest The user request containing user details.
     * @return UserResponse containing the created user details.
     */
    @Override
    public UserResponse create(UserRequest userRequest) {

        // Creating a new User entity
        User user = new User();

        // Setting user properties from userRequest
        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());
        user.setAge(userRequest.getAge());
        user.setCity(userRequest.getCity());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());

        // Saving the user entity to the database
        userRepository.save(user);

        // Creating a response object to return
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setGender(user.getGender());
        userResponse.setAge(user.getAge());
        userResponse.setCity(user.getCity());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }


    /**
     * Updates an existing user based on the provided user request.
     *
     * @param userRequest The user request containing updated user details.
     * @return UserResponse containing the updated user details.
     */
    @Override
    public UserResponse update(UserRequest userRequest) {

        // Creating a new User entity
        User user = new User();

        // Setting user properties from userRequest
        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());
        user.setAge(userRequest.getAge());
        user.setCity(userRequest.getCity());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());

        // Saving the updated user entity to the database
        userRepository.save(user);

        // Creating a response object to return
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setGender(user.getGender());
        userResponse.setAge(user.getAge());
        userResponse.setCity(user.getCity());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    /**
     * Deletes a user identified by the given user ID.
     *
     * @param userId The ID of the user to delete.
     */
    @Override
    public void delete(Long userId) {
        if(userRepository.existsById(userId))
        {
            userRepository.deleteById(userId);
        }
        else {
            throw new UserNotFoundException("User with id " + userId + " not found.");
        }
    }

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserResponse objects representing all users.
     */
    @Override
    public List<UserResponse> get() {

        // Fetching all users from the database
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        // Mapping User entities to UserResponse objects
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setGender(user.getGender());
            userResponse.setAge(user.getAge());
            userResponse.setCity(user.getCity());
            userResponse.setPhoneNumber(user.getPhoneNumber());
            userResponse.setEmail(user.getEmail());
            userResponses.add(userResponse);
        }

        return userResponses;
    }

    @Override
    public UserResponse getDataByUserId(Long userId) {
        if(userRepository.existsById(userId))
        {
            return userRepository.getDataByUserId(userId);
        }
        else {
            throw new UserNotFoundException("User is found with this "+userId);
        }

    }
}
