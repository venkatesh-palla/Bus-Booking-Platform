package com.example.bus.api.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long userId;
    private String firstName;
    private String lastName;
    private String city;
    private String gender;
    private long age;
    private String phoneNumber;
    private String email;
}
