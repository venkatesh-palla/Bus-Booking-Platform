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


    /**
     * Endpoint to handle creating a new booking.
     *
     * @param bookingsRequest The request body containing booking details.
     */
    @PostMapping("/createBooking")
    public void createBooking(@RequestBody BookingsRequest bookingsRequest) {
        bookingsService.createBooking(bookingsRequest);
    }


    /**
     * Endpoint to retrieve booking details by booking ID.
     *
     * @param bookingId The ID of the booking to retrieve.
     * @return BookingsResponse containing booking details.
     */
    @GetMapping("/{bookingId}")
    public BookingsResponse getDataByBookingId(@PathVariable String bookingId) {
        return bookingsService.getDataByBookingId(bookingId);
    }


    /**
     * Endpoint to retrieve all bookings.
     *
     * @return List of BookingsResponse containing details of all bookings.
     */
    @GetMapping("/allBookings")
    public List<BookingsResponse> getAllBookings() {
        return bookingsService.getAllBookings();
    }
}
