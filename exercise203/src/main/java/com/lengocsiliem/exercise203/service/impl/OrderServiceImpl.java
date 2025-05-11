package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Order;
import com.lengocsiliem.exercise203.repository.OrderRepository;
import com.lengocsiliem.exercise203.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(String id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setCoupon(orderDetails.getCoupon());
        order.setCustomer(orderDetails.getCustomer());
        order.setOrderStatus(orderDetails.getOrderStatus());
        order.setOrderApprovedAt(orderDetails.getOrderApprovedAt());
        order.setOrderDeliveredCarrierDate(orderDetails.getOrderDeliveredCarrierDate());
        order.setOrderDeliveredCustomerDate(orderDetails.getOrderDeliveredCustomerDate());
        order.setUpdatedBy(orderDetails.getUpdatedBy()); // Assuming you're passing updatedBy as part of the request
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
