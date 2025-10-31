package com.willjager.product_service.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductServiceException extends RuntimeException {

    private String statusCode;

    public ProductServiceException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
