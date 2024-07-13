package com.javid.product.mapper;

import com.javid.product.entity.Product;
import com.javid.product.model.request.ProductRequest;
import com.javid.product.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryMapper categoryMapper;

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .category(categoryMapper.toCategoryDTO(product.getCategory()))
                .build();
    }

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .availableQuantity(productRequest.getAvailableQuantity())
                .build();
    }
}
