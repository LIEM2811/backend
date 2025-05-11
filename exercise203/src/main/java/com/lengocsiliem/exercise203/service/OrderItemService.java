package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.OrderItem;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    Optional<OrderItem> getOrderItemById(UUID id);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(UUID id, OrderItem orderItemDetails);

    void deleteOrderItem(UUID id);
}
