package com.willjager.payment_service.service.impl;

import com.willjager.payment_service.entity.Payment;
import com.willjager.payment_service.entity.TransactionDetail;
import com.willjager.payment_service.model.PaymentRequest;
import com.willjager.payment_service.repository.PaymentRepository;
import com.willjager.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setOrderId(paymentRequest.getOrderId());
        transactionDetail.setAmount(paymentRequest.getAmount());
        transactionDetail.setPaymentDate(Instant.now());
        transactionDetail.setPaymentMode(paymentRequest.getPaymentMethod().name());
        transactionDetail.setReferenceNumber(paymentRequest.getReferenceNumber());
        transactionDetail.setPaymentStatus("SUCCESS");

        transactionDetail = paymentRepository.save(transactionDetail);
        return transactionDetail.getId();
    }

//
//    @Override
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//
//    @Override
//    public Payment getPaymentById(Long paymentId) {
//        return paymentRepository.findById(paymentId).get();
//    }
//
//    @Override
//    public Payment savePayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
}
