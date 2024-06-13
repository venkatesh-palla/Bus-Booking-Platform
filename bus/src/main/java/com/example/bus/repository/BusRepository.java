package com.example.bus.repository;

import com.example.bus.entity.Bus;
import com.example.bus.entity.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,String> {

    @Query(value = "SELECT * FROM bus WHERE bus_name = :busName",nativeQuery = true)
    List<Bus> getBusByName(@Param("busName") String busName);

    @Query(value = "SELECT * FROM bus WHERE source = :source AND destination = :destination And date = :date",nativeQuery = true)
    List<Bus> getBusBySourceAndDestinationByTime(@Param("source") String source,@Param("destination") String destination,@Param("date") Date date);

    @Query(value = "SELECT * FROM bus WHERE time = :time", nativeQuery = true)
    List<Bus>  getBusByTime(@Param("time") Timestamp time);

    @Query(value = "SELECT * FROM bus WHERE bus_type = :busType",nativeQuery = true)
    List<Bus> busType(@Param("busType")BusType busType);



    @Query(value = "SELECT " +
            "b1.bus_id AS firstBusId, b1.bus_name AS firstBusName, " +
            "b1.source AS firstBusSource,b1.destination AS firstBusDestination, " +
            "b1.time AS firstBusTime,b2.bus_id AS secondBusId, " +
            "b2.bus_name AS secondBusName,b2.source AS secondBusSource, " +
            "b2.destination AS secondBusDestination,b2.time AS secondBusTime " +
            "FROM bus.bus b1 " +
            "INNER JOIN bus.bus b2 ON b1.destination = b2.source WHERE b1.source = :firstBusSource " +
            "AND b1.destination = b2.source AND b2.destination = :secondBusDestination",
            nativeQuery = true)
    List<Bus> findConnectingBuses(@Param("firstBusSource") String firstBusSource,
                                  @Param("secondBusDestination") String secondBusDestination);




}
