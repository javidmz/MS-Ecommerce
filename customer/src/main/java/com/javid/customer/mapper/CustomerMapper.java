package com.javid.customer.mapper;

import com.javid.customer.entity.Address;
import com.javid.customer.entity.Customer;
import com.javid.customer.model.request.CustomerRequest;
import com.javid.customer.model.response.AddressOverviewResponse;
import com.javid.customer.model.response.CustomerOverviewResponse;
import com.javid.customer.model.response.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();
    }

    public CustomerOverviewResponse toCustomerOverviewResponse(CustomerResponse customerResponse) {
        return CustomerOverviewResponse.builder()
                .id(customerResponse.getId())
                .firstName(customerResponse.getFirstName())
                .lastName(customerResponse.getLastName())
                .email(customerResponse.getEmail())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .addresses(toListAddressResponse(customer.getAddresses()))
                .build();
    }

    public List<AddressOverviewResponse> toListAddressResponse(List<Address> addresses) {
        List<AddressOverviewResponse> addressOverviewResponses = new ArrayList<>();

        if(addresses != null && !addresses.isEmpty())
            for (Address address : addresses) {
                addressOverviewResponses.add(
                        AddressOverviewResponse.builder()
                                .id(address.getId())
                                .street(address.getStreet())
                                .city(address.getCity())
                                .postalCode(address.getPostalCode())
                                .build()
                );
            }

        return addressOverviewResponses;
    }
}
