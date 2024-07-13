package com.javid.product.service;

import com.javid.product.entity.Product;
import com.javid.product.model.ProductOrderDTO;
import com.javid.product.model.request.ProductPurchaseRequest;
import com.javid.product.model.request.ProductRequest;
import com.javid.product.model.response.ProductPurchaseResponse;
import com.javid.product.model.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProducts(Integer pageNo, Integer pageSize);

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProductResponse(int productId);

    Product getProduct(int productId);

    ProductResponse updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(int productId);

    ProductPurchaseResponse purchaseProduct(List<ProductOrderDTO> productOrderDTOS);
}
