package com.example.bus.controller;

import com.example.bus.api.request.bookings.BookingsRequest;
import com.example.bus.api.response.bookings.BookingsResponse;
import com.example.bus.service.Bookings.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Booking")
public class BookingsController {

    @Autowired
    BookingsService bookingsService;

    @PostMapping("/createBooking")
    public void createBooking(@RequestBody BookingsRequest bookingsRequest) {
        bookingsService.createBooking(bookingsRequest);
    }


    @GetMapping("/{bookingId}")
    public BookingsResponse getDataByBookingId(@PathVariable String bookingId) {
           return bookingsService.getDataByBookingId(bookingId);
    }



    @GetMapping("/allBookings")
    public List<BookingsResponse> getAllBookings() {
        return bookingsService.getAllBookings();
    }



}
