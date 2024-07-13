package com.javid.customer.service;

import com.javid.customer.model.request.AddressRequest;
import com.javid.customer.model.response.AddressResponse;

import java.util.List;

public interface AddressService {

    List<AddressResponse> getAllAddressesByCustomerId(Long customerId);

    AddressResponse addAddress(AddressRequest address);

    void deleteAddress(int id);
}
