package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.OrderStatus;
import com.lengocsiliem.exercise203.service.OrderStatusService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order-statuses")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusService.getAllOrderStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getOrderStatusById(@PathVariable UUID id) {
        return orderStatusService.getOrderStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderStatus createOrderStatus(@RequestBody OrderStatus orderStatus) {
        return orderStatusService.createOrderStatus(orderStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable UUID id,
            @RequestBody OrderStatus orderStatusDetails) {
        OrderStatus updatedOrderStatus = orderStatusService.updateOrderStatus(id, orderStatusDetails);
        return ResponseEntity.ok(updatedOrderStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable UUID id) {
        orderStatusService.deleteOrderStatus(id);
        return ResponseEntity.noContent().build();
    }
}
