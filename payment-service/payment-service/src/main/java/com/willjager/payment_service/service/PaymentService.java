package com.willjager.payment_service.service;

import com.willjager.payment_service.entity.Payment;
import com.willjager.payment_service.model.PaymentRequest;

import java.util.List;

public interface PaymentService {

    Long doPayment(PaymentRequest paymentRequest);

//    List<Payment> getAllPayments();
//
//    Payment getPaymentById(Long paymentId);
//
//    Payment savePayment(Payment payment);
}
