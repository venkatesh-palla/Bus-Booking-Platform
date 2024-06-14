package com.example.bus.service.payment;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;

import java.util.List;


public interface PaymentService {

    /**
     * Retrieves payment details by payment ID.
     *
     * @param paymentId The ID of the payment to retrieve.
     * @return PaymentResponse containing payment details.
     */
    public PaymentResponse getPaymentById(String paymentId);


    /**
     * Processes a payment based on the provided payment request.
     *
     * @param paymentRequest The payment request containing payment details.
     * @throws Exception If an error occurs during payment processing.
     */
    public void doPayment(PaymentRequest paymentRequest) throws Exception;


    /**
     * Retrieves all payments.
     *
     * @return List of PaymentResponse  representing all payments.
     */
    public List<PaymentResponse> getAllPayments();
}
