package com.example.bus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paymentId")
    private String paymentId;

    @Column(name = "paymentType")
    private String paymentType;

    @Column(name = "amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
    private Bookings booking;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "busId", referencedColumnName = "busId")
    private Bus busId;

    @Column(name = "paymentDate")
    private LocalDateTime paymentDate;

}
