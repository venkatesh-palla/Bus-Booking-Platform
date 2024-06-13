package com.example.bus.service.user;

import com.example.bus.entity.User;
import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;
import com.example.bus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;



    @Override
    public UserResponse create(UserRequest userRequest) {

        User user = new User();

        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());
        user.setAge(userRequest.getAge());
        user.setCity(userRequest.getCity());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());

        userRepository.save(user);

        UserResponse userResponse  = new UserResponse();
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

    @Override
    public UserResponse update(UserRequest userRequest) {
        User user = new User();

        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());
        user.setAge(userRequest.getAge());
        user.setCity(userRequest.getCity());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());

        userRepository.save(user);

        UserResponse userResponse  = new UserResponse();
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

    @Override
    public void delete(Long userId) {

        userRepository.deleteById(userId);
    }

    @Override
    public List<UserResponse> get() {

        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for(User i:users)
        {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(i.getUserId());
            userResponse.setFirstName(i.getFirstName());
            userResponse.setLastName(i.getLastName());
            userResponse.setGender(i.getGender());
            userResponse.setAge(i.getAge());
            userResponse.setCity(i.getCity());
            userResponse.setPhoneNumber(i.getPhoneNumber());
            userResponse.setEmail(i.getEmail());
            userResponses.add(userResponse);
        }

        return userResponses;
    }
}
