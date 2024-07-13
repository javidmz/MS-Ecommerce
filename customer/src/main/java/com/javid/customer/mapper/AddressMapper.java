package com.javid.customer.mapper;

import com.javid.customer.entity.Address;
import com.javid.customer.model.request.AddressRequest;
import com.javid.customer.model.response.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressMapper {
    private final CustomerMapper customerMapper;

    public List<AddressResponse> toAddressResponse(List<Address> addresses) {
        List<AddressResponse> addressResponses = new ArrayList<>();

        for (Address address : addresses) {
            addressResponses.add(
                    AddressResponse.builder()
                            .id(address.getId())
                            .street(address.getStreet())
                            .city(address.getCity())
                            .postalCode(address.getPostalCode())
                            .customer(customerMapper.toCustomerOverviewResponse(customerMapper.toCustomerResponse(address.getCustomer())))
                            .build()
            );
        }

        return addressResponses;
    }

    public Address toAddress(AddressRequest addressRequest) {
        return Address.builder()
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .postalCode(addressRequest.getPostalCode())
                .build();
    }

    public AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .customer(customerMapper.toCustomerOverviewResponse(customerMapper.toCustomerResponse(address.getCustomer())))
                .build();
    }

}
