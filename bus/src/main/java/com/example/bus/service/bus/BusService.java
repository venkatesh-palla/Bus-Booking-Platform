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

    /**
     * Creates a new bus.
     *
     * @param busRequest the request containing bus details.
     * @return the created bus data wrapped in a BusResponse object.
     */
    public BusResponse create(BusRequest busRequest);


    /**
     * Updates an existing bus.
     *
     * @param busRequest the request containing updated bus details.
     * @return the updated bus data wrapped in a BusResponse object.
     */
    public BusResponse update(BusRequest busRequest);


    /**
     * Deletes a bus by its ID.
     *
     * @param busId the ID of the bus to delete.
     */
    public void delete(String busId);


    /**
     * Retrieves all buses.
     *
     * @return a list of all buses wrapped in BusResponse objects.
     */
    public List<BusResponse> getBuses();


    /**
     * Retrieves buses by their name.
     *
     * @param busName the name of the bus to search for.
     * @return a list of buses matching the name wrapped in BusResponse objects.
     */
    public List<BusResponse> getBusByName(String busName);


    /**
     * Retrieves buses by their source, destination, and date.
     *
     * @param source      the source location of the bus.
     * @param destination the destination location of the bus.
     * @param date        the date of the bus journey.
     * @return a list of buses matching the criteria wrapped in BusResponse objects.
     */
    public List<BusResponse> getBusBySourceAndDestinationByTime(String source, String destination, Date date);


    /**
     * Retrieves buses by their departure time.
     *
     * @param time the departure time of the bus.
     * @return a list of buses matching the time wrapped in BusResponse objects.
     */
    public List<BusResponse> getBusByTime(Timestamp time);


    /**
     * Retrieves buses by their type.
     *
     * @param busType the type of the bus.
     * @return a list of buses matching the type wrapped in BusResponse objects.
     */
    public List<BusResponse> busType(BusType busType);


    /**
     * Retrieves buses that connect from a given source to a destination via another bus.
     *
     * @param firstBusSource       the source location of the first bus.
     * @param secondBusDestination the destination location of the second bus.
     * @return a list of connected buses wrapped in ConnectedBusApiResponse objects.
     */
    public List<ConnectedBusApiResponse> getConnectedBuses(String firstBusSource, String secondBusDestination);

}
