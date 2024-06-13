package com.example.bus.entity;

import com.example.bus.entity.Bus;
import com.example.bus.entity.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bookingId")
    private String bookingId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "seatNumber")
    private Long seatNumber;

    @Column(name = "seatType")
    private String seatType;


    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "busId", referencedColumnName = "busId")
    private Bus bus;

     @Column(name = "bookingDate")
     private LocalDate bookingDate;

     @Column(name = "departureTime")
     private LocalTime departureTime;

     @Column(name = "bookingStatus")
     private String bookingStatus;
}
