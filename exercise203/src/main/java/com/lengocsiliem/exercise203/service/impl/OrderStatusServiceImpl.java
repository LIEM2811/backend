package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.OrderStatus;
import com.lengocsiliem.exercise203.repository.OrderStatusRepository;
import com.lengocsiliem.exercise203.service.OrderStatusService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

    @Override
    public Optional<OrderStatus> getOrderStatusById(UUID id) {
        return orderStatusRepository.findById(id);
    }

    @Override
    public OrderStatus createOrderStatus(OrderStatus orderStatus) {
        orderStatus.setCreatedAt(LocalDateTime.now());
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(UUID id, OrderStatus orderStatusDetails) {
        OrderStatus orderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Status not found"));
        orderStatus.setStatusName(orderStatusDetails.getStatusName());
        orderStatus.setColor(orderStatusDetails.getColor());
        orderStatus.setPrivacy(orderStatusDetails.getPrivacy());
        orderStatus.setUpdatedAt(LocalDateTime.now());
        orderStatus.setUpdatedBy(orderStatusDetails.getUpdatedBy()); // Assuming you're passing updatedBy as part of the
                                                                     // request
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void deleteOrderStatus(UUID id) {
        orderStatusRepository.deleteById(id);
    }
}
