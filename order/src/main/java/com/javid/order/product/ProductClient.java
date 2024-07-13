package com.javid.order.product;

import com.javid.order.decoder.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@FeignClient(
        name = "PRODUCT-SERVICE",
        path = "/api/v1/product",
        configuration = CustomErrorDecoder.class
)
public interface ProductClient {
    @PostMapping("/reduce")
    void purchaseProduct(@RequestBody List<ProductOrderRequest> productOrderRequestList);
}
