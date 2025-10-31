package com.willjager.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long productId;
    private Long quantity;
    private Long amount;
    private PaymentMethod paymentMethod;
}
