package com.willjager.order_service.service;

import com.willjager.order_service.entity.Order;
import com.willjager.order_service.model.OrderRequest;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order saveOrder(Order order);

    Long placeOrder(OrderRequest orderRequest);

}
