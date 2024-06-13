package com.example.bus.service.user;

import com.example.bus.api.request.user.UserRequest;
import com.example.bus.api.response.user.UserResponse;

import java.util.List;

public interface UserService {

    public UserResponse create(UserRequest userRequest);

    public  UserResponse update(UserRequest userRequest);

    public  void delete(Long userId);

    public List<UserResponse> get();

}
