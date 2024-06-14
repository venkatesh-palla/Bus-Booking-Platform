package com.example.bus.controller;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;
import com.example.bus.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

        @Autowired
        PaymentService paymentService;

        @GetMapping("/{paymentId}")
        public PaymentResponse getPaymentById(@PathVariable String paymentId) {
            return paymentService.getPaymentById(paymentId);
        }

        @PostMapping("/doPayment")
        public void doPayment(@RequestBody PaymentRequest paymentRequest ) throws Exception {
                paymentService.doPayment(paymentRequest);
        }




        @GetMapping()
        public List<PaymentResponse> getAllPayments() {
                return paymentService.getAllPayments();
        }



}
