package com.example.bus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private long age;

    @Column(name = "phoneNumber",length = 10)
    private String phoneNumber;

    @Column(name = "email",unique = true)
    private String email;


}
