package com.willjager.product_service.service;

import com.willjager.product_service.entity.Product;
import com.willjager.product_service.model.ProductRequest;
import com.willjager.product_service.model.ProductResponse;

import java.util.List;

public interface ProductService {

//    List<Product> getAllProducts();
//
//    Product getProductById(Long productId);
//
//    Product saveProduct(Product product);

    ProductResponse addProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long productId);

    void reduceQuantity(Long productId, Long quantity);

}
