package com.example.bus.repository;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;
import com.example.bus.entity.Bus;
import com.example.bus.entity.BusType;
import com.example.bus.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {



    @Query(value = "SELECT booking_id FROM bookings where booking_id = :bookingId",nativeQuery = true)
    public void doPayment(@Param("bookingId") String bookingId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE bookings SET booking_status = 'Sucessfull' WHERE booking_id = :bookingId",nativeQuery = true)
    public void sucess(@Param("bookingId") String bookingId);







}
