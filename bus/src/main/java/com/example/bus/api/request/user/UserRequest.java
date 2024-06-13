package com.example.bus.api.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private long userId;
    private String firstName;
    private String lastName;
    private String city;
    private String gender;
    private long age;
    private String phoneNumber;
    private String email;
}
