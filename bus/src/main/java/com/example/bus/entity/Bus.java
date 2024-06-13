package com.example.bus.entity;

import com.example.bus.entity.BusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {

    @Id
    @Column(name = "busId")
    private String busId;

    @Column(name = "bus_name")
    private String busName;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "totalSeats")
    private Long totalSeats;

    @Column(name = "availableSeats")
    private Long availableSeats;

    @Column(name = "ticket_price")
    private Double ticketPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "busType")
    private BusType busType;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Timestamp time;

}
