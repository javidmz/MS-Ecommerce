package com.javid.order.customer;

import com.javid.order.decoder.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "CUSTOMER-SERVICE",
        path = "/api/v1/customer",
        configuration = CustomErrorDecoder.class
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    Optional<CustomerResponse> getCustomer(@PathVariable("customerId") Long customerId);
}
