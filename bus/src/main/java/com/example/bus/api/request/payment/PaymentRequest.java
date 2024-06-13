package com.example.bus.api.request.payment;

import com.example.bus.entity.Bookings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String paymentId;
    private String paymentType;
    private Double amount;
    private Bookings bookings;
    private String status;
    private LocalDateTime paymentDate;

    private String bookingId;
    private String userId;
    private String fullName;
}
