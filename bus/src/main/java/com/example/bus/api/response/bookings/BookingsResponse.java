package com.example.bus.api.response.bookings;

import com.example.bus.entity.Bookings;
import com.example.bus.entity.Bus;
import com.example.bus.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsResponse {

    private String bookingId;
    private String fullName;
    private Long age;
    private String gender;
    private Long seatNumber;
    private String seatType;
    private String phoneNumber;
    private Payment payment;
    private Bus bus;

    private LocalDate bookingDate;
    private LocalTime departureTime;
    private String bookingStatus;

    private String busId;
    private String busName;
    private String source;
    private String destination;

    private Double amount;
    private String status;
}
