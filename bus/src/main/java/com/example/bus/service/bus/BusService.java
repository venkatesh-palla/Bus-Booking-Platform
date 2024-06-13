package com.example.bus.service.bus;

import com.example.bus.api.request.bus.ConnectedBusApiRequest;
import com.example.bus.api.response.bus.ConnectedBusApiResponse;
import com.example.bus.entity.BusType;
import com.example.bus.api.request.bus.BusRequest;
import com.example.bus.api.response.bus.BusResponse;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public interface BusService {

    public BusResponse create(BusRequest busRequest);

    public BusResponse update(BusRequest busRequest);

    public void delete(String busId);

    public List<BusResponse> getBuses();


    public List<BusResponse> getBusByName(String busName);

    public List<BusResponse> getBusBySourceAndDestinationByTime(String source, String destination, Date date);

    public List<BusResponse> getBusByTime(Timestamp time);

    public List<BusResponse> busType(BusType busType);


    public List<ConnectedBusApiResponse> getConnectedBuses(String firstBusSource, String secondBusDestination);




}
