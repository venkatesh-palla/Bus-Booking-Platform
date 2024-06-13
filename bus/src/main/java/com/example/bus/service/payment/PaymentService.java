package com.example.bus.service.payment;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;

import java.util.List;

public interface PaymentService {

    public PaymentResponse getPaymentById(String paymentId);
    public void doPayment(PaymentRequest paymentRequest) throws Exception;
    public List<PaymentResponse> getAllPayments();
}
