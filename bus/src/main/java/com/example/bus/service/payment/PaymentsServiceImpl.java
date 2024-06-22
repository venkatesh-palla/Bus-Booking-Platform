package com.example.bus.service.payment;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;
import com.example.bus.entity.Bookings;
import com.example.bus.entity.Payment;
import com.example.bus.repository.BookingsRepository;
import com.example.bus.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PaymentsServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    BookingsRepository bookingsRepository;


    /**
     * Retrieves payment details by payment ID.
     *
     * @param paymentId The ID of the payment to retrieve.
     * @return PaymentResponse containing payment details.
     */
    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        // Retrieve payment details from the repository based on paymentId
        Payment payment = paymentRepository.findById(paymentId).get();

        // Initialize PaymentResponse object to populate with payment details
        PaymentResponse paymentResponse = new PaymentResponse();

        // Populate PaymentResponse with payment details
        paymentResponse.setPaymentId(payment.getPaymentId());
        paymentResponse.setPaymentType(payment.getPaymentType());
        paymentResponse.setStatus(payment.getStatus());
        paymentResponse.setAmount(payment.getAmount());

        // Retrieve booking details related to this payment
        Bookings bookings = payment.getBooking();
        if (bookings != null) {
            paymentResponse.setFullName(bookings.getFullName());
        }

        return paymentResponse;
    }


    /**
     * Processes a payment based on the provided payment request.
     *
     * @param paymentRequest The payment request containing payment details.
     * @throws Exception If an error occurs during payment processing.
     */
    public void doPayment(PaymentRequest paymentRequest) throws Exception {
        String bookingId = paymentRequest.getBookingId();
        Double amount = paymentRequest.getAmount();

        // Retrieve booking details from the repository based on bookingId
        Optional<Bookings> bookingOptional = bookingsRepository.findById(bookingId);

        // Check if the booking exists
        if (bookingOptional.isPresent()) {
            Bookings booking = bookingOptional.get();

            // Create a new Payment object and populate it with payment details
            Payment payment = new Payment();
            payment.setBooking(booking);
            payment.setAmount(amount);  // Use amount directly from paymentRequest
            payment.setPaymentType(paymentRequest.getPaymentType());
            payment.setStatus(paymentRequest.getStatus());
            payment.setPaymentDate(paymentRequest.getPaymentDate());

            // Save payment details
            paymentRepository.save(payment);

            // Process payment based on amount
            if (amount == 10000) {
                // Mark booking as successful
                paymentRepository.sucess(bookingId);
            } else {
                // Mark booking as unsuccessful
                paymentRepository.unSucess(bookingId);
            }
        } else {
            // Throw exception if booking is not found
            throw new Exception("Booking not found with id: " + bookingId);
        }
    }



    /**
     * Retrieves all payments.
     *
     * @return List of PaymentResponse objects representing all payments.
     */
    public List<PaymentResponse> getAllPayments() {
        // Retrieve all payments from the repository
        List<Payment> payments = paymentRepository.findAll();

        // Initialize list to store PaymentResponse objects
        List<PaymentResponse> paymentResponses = new ArrayList<>();

        // Iterate through each Payment object and create corresponding PaymentResponse objects
        for (Payment payment : payments) {
            PaymentResponse paymentResponse = new PaymentResponse();

            // Populate PaymentResponse with payment details
            paymentResponse.setPaymentId(payment.getPaymentId());
            paymentResponse.setPaymentType(payment.getPaymentType());
            paymentResponse.setStatus(payment.getStatus());
            paymentResponse.setAmount(payment.getAmount());

            // Retrieve booking details related to this payment
            Bookings bookings = payment.getBooking();
            if (bookings != null) {
                paymentResponse.setFullName(bookings.getFullName());
            }

            // Add PaymentResponse to the list
            paymentResponses.add(paymentResponse);
        }
        return paymentResponses;
    }
}
