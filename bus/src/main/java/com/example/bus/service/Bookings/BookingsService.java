package com.example.bus.service.Bookings;


import com.example.bus.api.request.bookings.BookingsRequest;
import com.example.bus.api.request.bus.ConnectedBusApiRequest;
import com.example.bus.api.response.bookings.BookingsResponse;
import com.example.bus.api.response.bus.ConnectedBusApiResponse;

import java.util.List;


public interface BookingsService {

    public BookingsResponse getDataByBookingId(String bookingId);
    public BookingsResponse createBooking(BookingsRequest bookingsRequest);

    public List<BookingsResponse> getAllBookings();






}
