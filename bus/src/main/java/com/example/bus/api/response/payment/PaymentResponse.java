package com.example.bus.api.response.payment;

import com.example.bus.entity.Bookings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String paymentId;
    private String paymentType;
    private Double amount;
    private Bookings Bookings;
    private String status;
    private LocalDateTime paymentDate;

    private String fullName;
    private String bookingId;
    private String userId;
}
