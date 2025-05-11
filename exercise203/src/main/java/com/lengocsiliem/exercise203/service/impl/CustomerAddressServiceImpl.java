package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.CustomerAddress;
import com.lengocsiliem.exercise203.repository.CustomerAddressRepository;
import com.lengocsiliem.exercise203.service.CustomerAddressService;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private final CustomerAddressRepository customerAddressRepository;

    public CustomerAddressServiceImpl(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    @Override
    public CustomerAddress createCustomerAddress(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public CustomerAddress getCustomerAddressById(UUID id) {
        return customerAddressRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerAddress> getAllCustomerAddresses() {
        return customerAddressRepository.findAll();
    }

    @Override
    public CustomerAddress updateCustomerAddress(UUID id, CustomerAddress customerAddress) {
        if (customerAddressRepository.existsById(id)) {
            customerAddress.setId(id);
            return customerAddressRepository.save(customerAddress);
        }
        return null;
    }

    @Override
    public void deleteCustomerAddress(UUID id) {
        customerAddressRepository.deleteById(id);
    }
}
