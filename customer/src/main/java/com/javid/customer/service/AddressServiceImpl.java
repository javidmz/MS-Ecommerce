package com.javid.customer.service;

import com.javid.customer.entity.Customer;
import com.javid.customer.entity.Address;
import com.javid.customer.exception.AddressNotFoundException;
import com.javid.customer.mapper.AddressMapper;
import com.javid.customer.model.request.AddressRequest;
import com.javid.customer.model.response.AddressResponse;
import com.javid.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerService customerService;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponse> getAllAddressesByCustomerId(Long customerId) {
        return addressMapper.toAddressResponse(addressRepository.findByCustomerId(customerId));
    }

    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
        Customer customer = customerService.getCustomer(addressRequest.getCustomer());
        Address address = addressMapper.toAddress(addressRequest);
        address.setCustomer(customer);
        return addressMapper.toAddressResponse(addressRepository.save(address));
    }

    @Override
    public void deleteAddress(int id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Such address does not exist"));

        addressRepository.delete(address);
    }
}
