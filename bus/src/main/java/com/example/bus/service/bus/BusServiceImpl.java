package com.example.bus.service.bus;

import com.example.bus.api.request.bus.ConnectedBusApiRequest;
import com.example.bus.api.response.bus.ConnectedBusApiResponse;
import com.example.bus.entity.Bus;
import com.example.bus.entity.BusType;
import com.example.bus.api.request.bus.BusRequest;
import com.example.bus.api.response.bus.BusResponse;
import com.example.bus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService{
    @Autowired
    BusRepository busRepository;

    @Override
    public BusResponse create(BusRequest busRequest) {
        Bus bus = new Bus();
        bus.setBusId(busRequest.getBusId());
        bus.setBusName(busRequest.getBusName());
        bus.setBusType(busRequest.getBusType());
        bus.setSource(busRequest.getSource());
        bus.setDestination(busRequest.getDestination());
        bus.setTicketPrice(busRequest.getTicketPrice());
        bus.setAvailableSeats(busRequest.getAvailableSeats());
        bus.setTotalSeats(busRequest.getTotalSeats());
        bus.setDate(busRequest.getDate());
        bus.setTime(busRequest.getTime());

        busRepository.save(bus);

        BusResponse  busResponse = new BusResponse();
        busResponse.setBusId(bus.getBusId());
        busResponse.setBusName(bus.getBusName());
        busResponse.setBusType(bus.getBusType());
        busResponse.setSource(bus.getSource());
        busResponse.setDestination(bus.getDestination());
        busResponse.setTicketPrice(bus.getTicketPrice());
        busResponse.setAvailableSeats(bus.getAvailableSeats());
        busResponse.setTotalSeats(bus.getTotalSeats());
        busResponse.setDate(bus.getDate());
        busResponse.setTime(bus.getTime());
        return busResponse;

    }

    @Override
    public BusResponse update(BusRequest busRequest) {
        Bus bus = new Bus();
        bus.setBusId(busRequest.getBusId());
        bus.setBusName(busRequest.getBusName());
        bus.setBusType(busRequest.getBusType());
        bus.setSource(busRequest.getSource());
        bus.setDestination(busRequest.getDestination());
        bus.setTicketPrice(busRequest.getTicketPrice());
        bus.setAvailableSeats(busRequest.getAvailableSeats());
        bus.setTotalSeats(busRequest.getTotalSeats());
        bus.setDate(busRequest.getDate());
        bus.setTime(busRequest.getTime());

        busRepository.save(bus);

        BusResponse  busResponse = new BusResponse();
        busResponse.setBusId(bus.getBusId());
        busResponse.setBusName(bus.getBusName());
        busResponse.setBusType(bus.getBusType());
        busResponse.setSource(bus.getSource());
        busResponse.setDestination(bus.getDestination());
        busResponse.setTicketPrice(bus.getTicketPrice());
        busResponse.setAvailableSeats(bus.getAvailableSeats());
        busResponse.setTotalSeats(bus.getTotalSeats());
        busResponse.setDate(bus.getDate());
        busResponse.setTime(bus.getTime());
        return busResponse;
    }

    @Override
    public void delete(String busId) {
        busRepository.deleteById(busId);

    }

    @Override
    public List<BusResponse> getBuses() {
        List<Bus> responses = busRepository.findAll();
        List<BusResponse> response =  new ArrayList<>();
        for(Bus i:responses)
        {
            BusResponse busResponse = new BusResponse();
            busResponse.setBusId(i.getBusId());
            busResponse.setBusName(i.getBusName());
            busResponse.setSource(i.getSource());
            busResponse.setDestination(i.getDestination());
            busResponse.setTime(i.getTime());
            busResponse.setAvailableSeats(i.getAvailableSeats());
            busResponse.setTotalSeats(i.getTotalSeats());
            busResponse.setBusType(i.getBusType());
            busResponse.setDate(i.getDate());
            busResponse.setTicketPrice(i.getTicketPrice());
            response.add(busResponse);
        }
        return response;
    }

    @Override
    public List<BusResponse> getBusByName(String busName) {

         List<Bus> responses = busRepository.getBusByName(busName);
        List<BusResponse> response =  new ArrayList<>();
        for(Bus i:responses)
        {
            BusResponse busResponse = new BusResponse();
            busResponse.setBusId(i.getBusId());
            busResponse.setBusName(i.getBusName());
            busResponse.setSource(i.getSource());
            busResponse.setDestination(i.getDestination());
            busResponse.setTime(i.getTime());
            busResponse.setAvailableSeats(i.getAvailableSeats());
            busResponse.setTotalSeats(i.getTotalSeats());
            busResponse.setBusType(i.getBusType());
            busResponse.setDate(i.getDate());
            busResponse.setTicketPrice(i.getTicketPrice());
            response.add(busResponse);
        }
        return response;
    }

    @Override
    public List<BusResponse> getBusBySourceAndDestinationByTime(String source, String destination, Date date) {
        List<Bus> responses = busRepository.getBusBySourceAndDestinationByTime(source,destination,date);
        List<BusResponse> response =  new ArrayList<>();
        for(Bus i:responses)
        {
            BusResponse busResponse = new BusResponse();
            busResponse.setBusId(i.getBusId());
            busResponse.setBusName(i.getBusName());
            busResponse.setSource(i.getSource());
            busResponse.setDestination(i.getDestination());
            busResponse.setTime(i.getTime());
            busResponse.setAvailableSeats(i.getAvailableSeats());
            busResponse.setTotalSeats(i.getTotalSeats());
            busResponse.setBusType(i.getBusType());
            busResponse.setDate(i.getDate());
            busResponse.setTicketPrice(i.getTicketPrice());
            response.add(busResponse);
        }
        return response;
    }

    @Override
    public List<BusResponse> getBusByTime(Timestamp time) {
        List<Bus> responses = busRepository.getBusByTime(time);
        List<BusResponse> response =  new ArrayList<>();
        for(Bus i:responses)
        {
            BusResponse busResponse = new BusResponse();
            busResponse.setBusId(i.getBusId());
            busResponse.setBusName(i.getBusName());
            busResponse.setSource(i.getSource());
            busResponse.setDestination(i.getDestination());
            busResponse.setTime(i.getTime());
            busResponse.setAvailableSeats(i.getAvailableSeats());
            busResponse.setTotalSeats(i.getTotalSeats());
            busResponse.setBusType(i.getBusType());
            busResponse.setDate(i.getDate());
            busResponse.setTicketPrice(i.getTicketPrice());
            response.add(busResponse);
        }
        return response;
    }

    @Override
    public List<BusResponse> busType(BusType busType) {
        List<Bus> responses = busRepository.busType(busType);
        List<BusResponse> response =  new ArrayList<>();
        for(Bus i:responses)
        {
            BusResponse busResponse = new BusResponse();
            busResponse.setBusId(i.getBusId());
            busResponse.setBusName(i.getBusName());
            busResponse.setSource(i.getSource());
            busResponse.setDestination(i.getDestination());
            busResponse.setTime(i.getTime());
            busResponse.setAvailableSeats(i.getAvailableSeats());
            busResponse.setTotalSeats(i.getTotalSeats());
            busResponse.setBusType(i.getBusType());
            busResponse.setDate(i.getDate());
            busResponse.setTicketPrice(i.getTicketPrice());
            response.add(busResponse);
        }
        return response;
    }

    public List<ConnectedBusApiResponse> getConnectedBuses(String firstBusSource, String secondBusDestination) {
        List<Object[]> results = busRepository.findConnectingBuses(firstBusSource, secondBusDestination);
        List<ConnectedBusApiResponse> connectedBusApiResponses = new ArrayList<>();

        for (Object[] result : results) {
            ConnectedBusApiResponse response = new ConnectedBusApiResponse();
            response.setFirstBusId((String) result[0]);
            response.setSecondBusId((String) result[5]);
            response.setFirstBusName((String) result[1]);
            response.setSecondBusName((String) result[6]);
            response.setFirstBusSource((String) result[2]);
            response.setSecondBusSource((String) result[7]);
            response.setFirstBusDestination((String) result[3]);
            response.setSecondBusDestination((String) result[8]);
            response.setFirstBusTime((Timestamp) result[4]);
            response.setSecondBusTime((Timestamp) result[9]);
            connectedBusApiResponses.add(response);
        }

        return connectedBusApiResponses;
    }



}