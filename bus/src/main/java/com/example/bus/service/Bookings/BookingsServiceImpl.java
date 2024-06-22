package com.example.bus.service.Bookings;

import com.example.bus.entity.Bookings;
import com.example.bus.api.request.bookings.BookingsRequest;
import com.example.bus.api.response.bookings.BookingsResponse;
import com.example.bus.entity.Bus;
import com.example.bus.entity.Payment;
import com.example.bus.exception.ResourceNotFoundException;
import com.example.bus.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public BookingsResponse getDataByBookingId(String bookingId) {
        Optional<Bookings> optionalBooking = bookingsRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Bookings object = optionalBooking.get();
            BookingsResponse bookingsResponse = new BookingsResponse();
            Bus bus = new Bus();
            Payment payment = new Payment();

            bookingsResponse.setBookingId(object.getBookingId());
            bookingsResponse.setAge(object.getAge());
            bookingsResponse.setBookingDate(object.getBookingDate());
            bookingsResponse.setBus(object.getBus());
            bookingsResponse.setGender(object.getGender());
            bookingsResponse.setPayment(object.getPayment());
            bookingsResponse.setFullName(object.getFullName());
            bookingsResponse.setDepartureTime(object.getDepartureTime());
            bookingsResponse.setSeatType(object.getSeatType());
            bookingsResponse.setPhoneNumber(object.getPhoneNumber());
            bookingsResponse.setSeatNumber(object.getSeatNumber());
            bookingsResponse.setBookingStatus(object.getBookingStatus());

            bookingsResponse.setBusId(bus.getBusId());
            bookingsResponse.setSource(bus.getSource());
            bookingsResponse.setDestination(bus.getDestination());
            bookingsResponse.setBusName(bus.getBusName());

            bookingsResponse.setStatus(payment.getStatus());
            bookingsResponse.setAmount(payment.getAmount());

            return bookingsResponse;
        } else {
            throw new ResourceNotFoundException("Booking not found with ID: " + bookingId);
        }
    }

    public BookingsResponse createBooking(BookingsRequest bookingsRequest) {
        Bookings bookings = new Bookings();

        bookings.setBookingId(bookingsRequest.getBookingId());
        bookings.setAge(bookingsRequest.getAge());
        bookings.setBookingDate(bookingsRequest.getBookingDate());
        bookings.setBus(bookingsRequest.getBus());
        bookings.setGender(bookingsRequest.getGender());
        bookings.setPayment(bookingsRequest.getPayment());
        bookings.setFullName(bookingsRequest.getFullName());
        bookings.setDepartureTime(bookingsRequest.getDepartureTime());
        bookings.setSeatType(bookingsRequest.getSeatType());
        bookings.setPhoneNumber(bookingsRequest.getPhoneNumber());
        bookings.setSeatNumber(bookingsRequest.getSeatNumber());

        bookingsRepository.save(bookings);

        BookingsResponse bookingsResponse = new BookingsResponse();

        bookingsResponse.setBookingId(bookings.getBookingId());
        bookingsResponse.setAge(bookings.getAge());
        bookingsResponse.setBookingDate(bookings.getBookingDate());
        bookingsResponse.setBus(bookings.getBus());
        bookingsResponse.setGender(bookings.getGender());
        bookingsResponse.setPayment(bookings.getPayment());
        bookingsResponse.setFullName(bookings.getFullName());
        bookingsResponse.setDepartureTime(bookings.getDepartureTime());
        bookingsResponse.setSeatType(bookings.getSeatType());
        bookingsResponse.setPhoneNumber(bookings.getPhoneNumber());
        bookingsResponse.setSeatNumber(bookings.getSeatNumber());

        return bookingsResponse;
    }

    @Override
    public List<BookingsResponse> getAllBookings() {
        List<Bookings> bookings = bookingsRepository.findAll();

        List<BookingsResponse> bookingsResponses = new ArrayList<>();

        for (Bookings i : bookings) {
            BookingsResponse bookingsResponse = new BookingsResponse();
            bookingsResponse.setBookingId(i.getBookingId());
            bookingsResponse.setAge(i.getAge());
            bookingsResponse.setBookingDate(i.getBookingDate());
            bookingsResponse.setBus(i.getBus());
            bookingsResponse.setGender(i.getGender());
            bookingsResponse.setPayment(i.getPayment());
            bookingsResponse.setFullName(i.getFullName());
            bookingsResponse.setDepartureTime(i.getDepartureTime());
            bookingsResponse.setSeatType(i.getSeatType());
            bookingsResponse.setPhoneNumber(i.getPhoneNumber());
            bookingsResponse.setSeatNumber(i.getSeatNumber());
            bookingsResponse.setBookingStatus(i.getBookingStatus());
            bookingsResponses.add(bookingsResponse);
        }
        return bookingsResponses;
    }
}
