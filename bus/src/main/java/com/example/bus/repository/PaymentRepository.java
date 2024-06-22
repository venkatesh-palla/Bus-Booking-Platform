package com.example.bus.repository;

import com.example.bus.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    /**
     * Checks if a booking exists by its ID.
     *
     * @param bookingId the ID of the booking.
     * @return the booking ID if it exists, otherwise null.
     */
    @Query(value = "SELECT booking_id FROM bookings where booking_id = :bookingId", nativeQuery = true)
    public void doPayment(@Param("bookingId") String bookingId);

    /**
     * Updates the booking status to 'Successful' for a given booking ID.
     *
     * @param bookingId the ID of the booking to be updated.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE bookings SET booking_status = 'Sucessfull' WHERE booking_id = :bookingId", nativeQuery = true)
    public void sucess(@Param("bookingId") String bookingId);



    @Query(value = "UPDATE bookings SET booking_status = 'unSucessfull' WHERE booking_id = :bookingId", nativeQuery = true)
    public void unSucess(@Param("bookingId") String bookingId);

}
