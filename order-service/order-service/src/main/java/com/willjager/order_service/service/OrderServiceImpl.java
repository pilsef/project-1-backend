package com.willjager.order_service.service;

import com.willjager.order_service.entity.Order;
import com.willjager.order_service.external.client.ProductService;
import com.willjager.order_service.model.OrderRequest;
import com.willjager.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        Order order = new Order();
        String ORDER_STATUS = "CREATED";
        order.setAmount(orderRequest.getAmount());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(Instant.now());
        order.setOrderStatus(ORDER_STATUS);

        order = orderRepository.save(order);
        return order.getOrderId();
    }


}
