package com.willjager.order_service.controller;

import com.willjager.order_service.entity.Order;
import com.willjager.order_service.model.OrderRequest;
import com.willjager.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    @GetMapping("/{id}")
//    public Order getOrderById(@PathVariable("id") Long orderId) {
//        return orderService.getOrderById(orderId);
//    }

//    @PostMapping
//    public Order saveOrder(@RequestBody Order order) {
//        return orderService.saveOrder(order);
//    }

    @PostMapping("/placed")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        Long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
