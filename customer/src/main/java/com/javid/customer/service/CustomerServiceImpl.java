package com.javid.customer.service;

import com.javid.customer.entity.Customer;
import com.javid.customer.exception.CustomerNotFoundException;
import com.javid.customer.mapper.CustomerMapper;
import com.javid.customer.model.request.CustomerRequest;
import com.javid.customer.model.response.CustomerResponse;
import com.javid.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse getCustomerResponse(Long id) {
        var customer = customerRepository.findById(id)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Customer not found with id: %s", id))
                );

        return customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Customer not found with id: %s", id))
                );
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(
                customerRepository.save(customerMapper.toCustomer(customerRequest))
        );

        return customerResponse;
    }

    @Override
    public void deleteCustomer(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest, Long customerId) {
        Customer customer = getCustomer(customerId);
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());

        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }
}
