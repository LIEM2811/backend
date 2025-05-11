package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;

import com.lengocsiliem.exercise203.entity.Order;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(String id);

    Order createOrder(Order order);

    Order updateOrder(String id, Order orderDetails);

    void deleteOrder(String id);
}
