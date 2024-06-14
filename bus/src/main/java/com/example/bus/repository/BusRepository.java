package com.example.bus.repository;

import com.example.bus.entity.Bus;
import com.example.bus.entity.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, String> {

    /**
     * Fetches a list of buses by their name.
     *
     * @param busName the name of the bus.
     * @return a list of buses with the specified name.
     */
    @Query(value = "SELECT * FROM bus WHERE bus_name = :busName", nativeQuery = true)
    List<Bus> getBusByName(@Param("busName") String busName);

    /**
     * Fetches a list of buses by their source, destination, and date.
     *
     * @param source      the source location of the bus.
     * @param destination the destination location of the bus.
     * @param date        the date of the bus trip.
     * @return a list of buses matching the specified source, destination, and date.
     */
    @Query(value = "SELECT * FROM bus WHERE source = :source AND destination = :destination AND date = :date", nativeQuery = true)
    List<Bus> getBusBySourceAndDestinationByTime(@Param("source") String source, @Param("destination") String destination, @Param("date") Date date);

    /**
     * Fetches a list of buses by their departure time.
     *
     * @param time the departure time of the bus.
     * @return a list of buses departing at the specified time.
     */
    @Query(value = "SELECT * FROM bus WHERE time = :time", nativeQuery = true)
    List<Bus> getBusByTime(@Param("time") Timestamp time);

    /**
     * Fetches a list of buses by their type.
     *
     * @param busType the type of the bus.
     * @return a list of buses of the specified type.
     */
    @Query(value = "SELECT * FROM bus WHERE bus_type = :busType", nativeQuery = true)
    List<Bus> busType(@Param("busType") BusType busType);

    /**
     * Finds connecting buses between two locations.
     * A connecting bus trip involves two buses where the destination of the first bus
     * is the source of the second bus.
     *
     * @param firstBusSource       the source location of the first bus.
     * @param secondBusDestination the destination location of the second bus.
     * @return a list of objects containing details of the connecting buses.
     */
    @Query(value = "SELECT " +
            "b1.bus_id AS firstBusId, b1.bus_name AS firstBusName, " +
            "b1.source AS firstBusSource, b1.destination AS firstBusDestination, " +
            "b1.time AS firstBusTime, b2.bus_id AS secondBusId, " +
            "b2.bus_name AS secondBusName, b2.source AS secondBusSource, " +
            "b2.destination AS secondBusDestination, b2.time AS secondBusTime " +
            "FROM bus.bus b1 " +
            "INNER JOIN bus.bus b2 ON b1.destination = b2.source " +
            "WHERE b1.source = :firstBusSource " +
            "AND b2.destination = :secondBusDestination",
            nativeQuery = true)
    List<Object[]> findConnectingBuses(@Param("firstBusSource") String firstBusSource,
                                       @Param("secondBusDestination") String secondBusDestination);

}
