package com.javid.order.payment;

import com.javid.order.decoder.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "PAYMENT-SERVICE",
        path = "/api/v1/payment",
        configuration = CustomErrorDecoder.class
)
public interface PaymentClient {

    @PostMapping
    PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest);
}
