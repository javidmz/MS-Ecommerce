package com.javid.customer.service;

import com.javid.customer.entity.Customer;
import com.javid.customer.model.request.CustomerRequest;
import com.javid.customer.model.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse getCustomerResponse(Long id);

    Customer getCustomer(Long id);

    CustomerResponse saveCustomer(CustomerRequest customerRequest);

    void deleteCustomer(Long id);

    CustomerResponse updateCustomer(CustomerRequest customerRequest, Long customerId);
}
