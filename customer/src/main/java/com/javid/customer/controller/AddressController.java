package com.javid.customer.controller;

import com.javid.customer.service.AddressService;
import com.javid.customer.model.request.AddressRequest;
import com.javid.customer.model.response.AddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<AddressResponse>> getAddress(@PathVariable Long customerId) {
        return ResponseEntity.ok(addressService.getAllAddressesByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@RequestBody @Valid AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.addAddress(addressRequest));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
