package com.javid.product.controller;

import com.javid.product.model.ProductOrderDTO;
import com.javid.product.model.request.ProductPurchaseRequest;
import com.javid.product.model.request.ProductRequest;
import com.javid.product.model.response.ProductPurchaseResponse;
import com.javid.product.model.response.ProductResponse;
import com.javid.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProduct(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "25") Integer pageSize
    ) {
        return ResponseEntity.ok(productService.getProducts(pageNo, pageSize));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable int productId) {
        return ResponseEntity.ok(productService.getProductResponse(productId));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/reduce")
    public ResponseEntity<ProductPurchaseResponse> reduceProduct(
            @RequestBody @Valid List<ProductOrderDTO> productOrderDTOS
    ) {
        return ResponseEntity.ok(productService.purchaseProduct(productOrderDTOS));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable int productId,
            @RequestBody @Valid ProductRequest productRequest
    ) {
        return ResponseEntity.ok(productService.updateProduct(productId, productRequest));
    }
}
