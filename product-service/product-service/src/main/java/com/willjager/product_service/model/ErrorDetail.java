package com.willjager.product_service.model;

import lombok.*;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetail {

    private String errorMessage;
    private String errorCode;
}
