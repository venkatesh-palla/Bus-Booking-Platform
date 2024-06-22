package com.example.bus.controller;

import com.example.bus.api.request.payment.PaymentRequest;
import com.example.bus.api.response.payment.PaymentResponse;
import com.example.bus.service.payment.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

        @Autowired
        PaymentService paymentService;


        /**
         * Endpoint to retrieve payment details by payment ID.
         *
         * @param paymentId The ID of the payment to retrieve.
         * @return PaymentResponse containing details of the payment.
         */
        @GetMapping("/{paymentId}")
        @Operation(summary = "Get payment by ID",
                description = "Retrieves details of a payment by its ID.")
        public PaymentResponse getPaymentById(@PathVariable String paymentId) {
                return paymentService.getPaymentById(paymentId);
        }


        /**
         * Endpoint to initiate a payment transaction.
         *
         * @param paymentRequest The request body containing payment details.
         * @throws Exception if payment processing fails.
         */
        @PostMapping("/doPayment")
        @Operation(summary = "Initiate payment",
                description = "Initiates a payment transaction")
        public void doPayment(@RequestBody PaymentRequest paymentRequest) throws Exception {
                paymentService.doPayment(paymentRequest);
        }


        /**
         * Endpoint to retrieve details of all payments.
         *
         * @return List of PaymentResponse containing details of all payments.
         */
        @GetMapping("/allPayments")
        @Operation(summary = "Get all payments", description = "Retrieves details of all payments.")
        public List<PaymentResponse> getAllPayments() {
                return paymentService.getAllPayments();
        }

}
