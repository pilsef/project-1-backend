package com.willjager.product_service.service.impl;

import com.willjager.product_service.entity.Product;
import com.willjager.product_service.exception.ProductServiceException;
import com.willjager.product_service.model.ProductRequest;
import com.willjager.product_service.model.ProductResponse;
import com.willjager.product_service.repository.ProductRepository;
import com.willjager.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> {
            ProductResponse productResponse = new ProductResponse();
            copyProperties(product, productResponse);
            return productResponse;
        }).toList();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductServiceException(
                        "Product not found with id: " + productId, "PRODUCT_NOT_FOUND"
                ));

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductServiceException(
                        "Product not found with id: " + productId, "PRODUCT_NOT_FOUND"
                ));

        if (product.getQuantity() < quantity) {
            throw new ProductServiceException(
                    "Insufficient quantity for product id: " + productId, "INSUFFICIENT_PRODUCT_QUANTITY"
            );
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
        }
    }


//    @Override
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public Product getProductById(Long productId) {
//        return productRepository.findById(productId).get();
//    }
//
//    @Override
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
}
