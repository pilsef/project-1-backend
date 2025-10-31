package com.willjager.payment_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {

    private Long orderId;
    private Long amount;
    private String referenceNumber;
    private PaymentMethod paymentMethod;

}
