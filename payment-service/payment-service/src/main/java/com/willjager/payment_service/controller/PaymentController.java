package com.willjager.payment_service.controller;

import com.willjager.payment_service.entity.Payment;
import com.willjager.payment_service.model.PaymentRequest;
import com.willjager.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/do-payment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        Long transactionId = paymentService.doPayment(paymentRequest);

        return ResponseEntity.ok(transactionId);

    }

//    @GetMapping
//    public List<Payment> getAllPayments() {
//        return paymentService.getAllPayments();
//    }
//
//    @GetMapping("/{id}")
//    public Payment getPaymentById(@PathVariable("id") Long paymentId) {
//        return paymentService.getPaymentById(paymentId);
//    }
//
//    @PostMapping
//    public Payment savePayment(@RequestBody Payment payment) {
//        return paymentService.savePayment(payment);
//    }
}
