package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.OrderItem;
import com.lengocsiliem.exercise203.repository.OrderItemRepository;
import com.lengocsiliem.exercise203.service.OrderItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(UUID id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItem orderItemDetails) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item not found"));
        orderItem.setProduct(orderItemDetails.getProduct());
        orderItem.setOrder(orderItemDetails.getOrder());
        orderItem.setPrice(orderItemDetails.getPrice());
        orderItem.setQuantity(orderItemDetails.getQuantity());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepository.deleteById(id);
    }
}
