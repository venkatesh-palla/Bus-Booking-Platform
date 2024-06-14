package com.example.bus.service.Bookings;

import com.example.bus.api.request.bookings.BookingsRequest;
import com.example.bus.api.response.bookings.BookingsResponse;

import java.util.List;


public interface BookingsService {

    /**
     * Retrieves booking data for a specific booking ID.
     *
     * @param bookingId the ID of the booking to retrieve.
     * @return the booking data wrapped in a BookingsResponse object.
     */
    public BookingsResponse getDataByBookingId(String bookingId);

    /**
     * Creates a new booking based on the provided booking request.
     *
     * @param bookingsRequest the request containing booking details.
     * @return the created booking data wrapped in a BookingsResponse object.
     */
    public BookingsResponse createBooking(BookingsRequest bookingsRequest);

    /**
     * Retrieves all bookings.
     *
     * @return a list of all bookings wrapped in BookingsResponse objects.
     */
    public List<BookingsResponse> getAllBookings();
}
