package com.example.bus.api.response.bus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedBusApiResponse {

    private String firstBusId;
    private String firstBusName;
    private String firstBusSource;
    private String firstBusDestination;
    private Timestamp firstBusTime;
    private String secondBusId;
    private String secondBusName;
    private String secondBusSource;
    private String secondBusDestination;
    private Timestamp secondBusTime;
}
