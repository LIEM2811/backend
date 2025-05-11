package com.lengocsiliem.exercise203.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.CustomerAddress;
import com.lengocsiliem.exercise203.service.CustomerAddressService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer-addresses")
public class CustomerAddressController {

    private final CustomerAddressService customerAddressService;

    public CustomerAddressController(CustomerAddressService customerAddressService) {
        this.customerAddressService = customerAddressService;
    }

    @PostMapping
    public ResponseEntity<CustomerAddress> createCustomerAddress(@RequestBody CustomerAddress customerAddress) {
        CustomerAddress createdCustomerAddress = customerAddressService.createCustomerAddress(customerAddress);
        return new ResponseEntity<>(createdCustomerAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddress> getCustomerAddressById(@PathVariable UUID id) {
        CustomerAddress customerAddress = customerAddressService.getCustomerAddressById(id);
        return customerAddress != null ? ResponseEntity.ok(customerAddress) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddresses() {
        List<CustomerAddress> customerAddresses = customerAddressService.getAllCustomerAddresses();
        return ResponseEntity.ok(customerAddresses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAddress> updateCustomerAddress(@PathVariable UUID id,
            @RequestBody CustomerAddress customerAddress) {
        CustomerAddress updatedCustomerAddress = customerAddressService.updateCustomerAddress(id, customerAddress);
        return updatedCustomerAddress != null ? ResponseEntity.ok(updatedCustomerAddress)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerAddress(@PathVariable UUID id) {
        customerAddressService.deleteCustomerAddress(id);
        return ResponseEntity.noContent().build();
    }
}
