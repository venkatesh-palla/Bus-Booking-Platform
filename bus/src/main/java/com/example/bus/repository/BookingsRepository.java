package com.example.bus.repository;

import com.example.bus.entity.Bookings;
import com.example.bus.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface BookingsRepository extends JpaRepository<Bookings, String> {

    /**
     * Fetches a list of buses by their name.
     *
     * @param busName the name of the bus.
     * @return a list of buses with the specified name.
     */
    @Query(value = "SELECT * FROM bus WHERE bus_name = :busName", nativeQuery = true)
    List<Bus> getBusByName(@Param("busName") String busName);

}
