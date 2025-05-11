package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.CustomerAddress;

public interface CustomerAddressService {
    CustomerAddress createCustomerAddress(CustomerAddress customerAddress);

    CustomerAddress getCustomerAddressById(UUID id);

    List<CustomerAddress> getAllCustomerAddresses();

    CustomerAddress updateCustomerAddress(UUID id, CustomerAddress customerAddress);

    void deleteCustomerAddress(UUID id);
}
