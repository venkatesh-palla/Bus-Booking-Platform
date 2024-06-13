package com.example.bus.api.request.bookings;

import com.example.bus.entity.Bus;
import com.example.bus.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingsRequest {

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

}
