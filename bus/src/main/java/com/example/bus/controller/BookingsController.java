package com.example.bus.controller;

import com.example.bus.api.request.bookings.BookingsRequest;
import com.example.bus.api.response.bookings.BookingsResponse;
import com.example.bus.service.Bookings.BookingsService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create a new booking", description = "Creates a new booking with the provided details.")
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
    @Operation(summary = "Get booking by ID", description = "Retrieves booking details by booking ID.")
    public BookingsResponse getDataByBookingId(@PathVariable String bookingId) {
        return bookingsService.getDataByBookingId(bookingId);
    }


    /**
     * Endpoint to retrieve all bookings.
     *
     * @return List of BookingsResponse containing details of all bookings.
     */
    @GetMapping("/allBookings")
    @Operation(summary = "Get all bookings", description = "Retrieves details of all bookings.")
    public List<BookingsResponse> getAllBookings() {
        return bookingsService.getAllBookings();
    }
}
