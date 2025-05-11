package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.OrderStatus;

public interface OrderStatusService {
    List<OrderStatus> getAllOrderStatuses();

    Optional<OrderStatus> getOrderStatusById(UUID id);

    OrderStatus createOrderStatus(OrderStatus orderStatus);

    OrderStatus updateOrderStatus(UUID id, OrderStatus orderStatusDetails);

    void deleteOrderStatus(UUID id);
}
