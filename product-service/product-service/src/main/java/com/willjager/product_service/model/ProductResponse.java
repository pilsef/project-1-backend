package com.willjager.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productName;
    private Long price;
    private Long quantity;
    private String photoUrl;
    private String description;
    private String category;
}
