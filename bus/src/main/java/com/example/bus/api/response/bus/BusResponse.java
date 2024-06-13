package com.example.bus.api.response.bus;

import com.example.bus.entity.BusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusResponse {

    private String busId;
    private String busName;
    private String source;
    private String destination;
    private Long totalSeats;
    private Long availableSeats;
    private Double ticketPrice;
    private BusType busType;
    private Date date;
    private Timestamp time;
}
