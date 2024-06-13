package com.example.bus.service.payment;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;
import com.example.bus.entity.Bookings;
import com.example.bus.entity.Payment;
import com.example.bus.repository.BookingsRepository;
import com.example.bus.repository.BusRepository;
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



    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        Payment payment = paymentRepository.findById(paymentId).get();

        PaymentResponse paymentResponse = new PaymentResponse();

        Bookings bookings = new Bookings();

        paymentResponse.setPaymentId(payment.getPaymentId());
        paymentResponse.setPaymentType(payment.getPaymentType());
        paymentResponse.setStatus(payment.getStatus());
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setFullName(bookings.getFullName());

        return paymentResponse;
    }

    public void doPayment(PaymentRequest paymentRequest) throws Exception {
        String bookingId = paymentRequest.getBookingId();
        Optional<Bookings> bookingOptional = bookingsRepository.findById(bookingId);

        if (bookingOptional.isPresent()) {
            Bookings booking = bookingOptional.get();

            Payment payment = new Payment();
            payment.setBooking(booking);
            payment.setAmount(paymentRequest.getAmount());
            payment.setPaymentType(paymentRequest.getPaymentType());
            payment.setStatus(paymentRequest.getStatus());
            payment.setPaymentDate(paymentRequest.getPaymentDate());
            boolean isRetry = true;
            int count = 1;
            while(isRetry && count <=2)
            {
                try {
                    paymentRepository.save(payment);

                    paymentRepository.sucess(bookingId);
                    break;
                }catch (Exception e)
                {
                    count++;
                   isRetry = true;
                }
            }

        } else {
            throw new Exception("Booking not found with id: " + bookingId);
        }
    }

    public List<PaymentResponse> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentResponse> paymentResponses = new ArrayList<>();

        for (Payment i : payments) {
            PaymentResponse paymentResponse = new PaymentResponse();
            Bookings bookings = new Bookings();
            paymentResponse.setPaymentId(i.getPaymentId());
            paymentResponse.setPaymentType(i.getPaymentType());
            paymentResponse.setStatus(i.getStatus());
            paymentResponse.setAmount(i.getAmount());
            paymentResponse.setFullName(bookings.getFullName());
            paymentResponses.add(paymentResponse);
        }
        return paymentResponses;
    }
}
