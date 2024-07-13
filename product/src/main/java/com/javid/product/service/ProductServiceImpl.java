package com.javid.product.service;

import com.javid.product.entity.Category;
import com.javid.product.entity.Product;
import com.javid.product.exception.CategoryNotFoundException;
import com.javid.product.exception.NotAvailableQuantityException;
import com.javid.product.exception.ProductNotFoundException;
import com.javid.product.mapper.ProductMapper;
import com.javid.product.model.ProductOrderDTO;
import com.javid.product.model.request.ProductPurchaseRequest;
import com.javid.product.model.request.ProductRequest;
import com.javid.product.model.response.ProductPurchaseResponse;
import com.javid.product.model.response.ProductResponse;
import com.javid.product.repository.CategoryRepository;
import com.javid.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getProducts(
            Integer pageNo,
            Integer pageSize
    ) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = productRepository.findAllBy(paging);
        return pagedResult
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Category category = categoryRepository.findById(productRequest.getCategoryId()).
                orElseThrow(() -> new CategoryNotFoundException("Such category does not exist."));
        product.setCategory(category);

        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse getProductResponse(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Such product does not exist."));
        return productMapper.toProductResponse(product);
    }

    @Override
    public Product getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(
                        format(
                                "Product with ID %s does not exist.",
                                productId
                        )));
    }

    @Override
    public ProductResponse updateProduct(int productId, ProductRequest productRequest) {
        Product product = getProduct(productId);
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setAvailableQuantity(productRequest.getAvailableQuantity());
        product.setCategory(categoryRepository.findById(productRequest.getCategoryId())
        .orElseThrow(() -> new CategoryNotFoundException("Such category does not exist.")));
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = getProduct(productId);
        productRepository.delete(product);
    }

    @Override
    public ProductPurchaseResponse purchaseProduct(List<ProductOrderDTO> productOrderDTOS) {
        BigDecimal totalPrice = BigDecimal.valueOf(0);

        for (ProductOrderDTO productOrderDTO : productOrderDTOS) {
            var product = getProduct(productOrderDTO.getProductId());
        }

        for (ProductOrderDTO productOrderDTO : productOrderDTOS) {
            var product = getProduct(productOrderDTO.getProductId());

            if(productOrderDTO.getQuantity() > product.getAvailableQuantity())
                throw new NotAvailableQuantityException(
                        format(
                                "Not available number of product with ID %s",
                                product.getId()
                        ));

            product.setAvailableQuantity(product.getAvailableQuantity() - productOrderDTO.getQuantity());
            totalPrice = totalPrice.add(product.getPrice().multiply(new BigDecimal(productOrderDTO.getQuantity())));
            productRepository.save(product);
        }

        return ProductPurchaseResponse.builder()
                .totalPrice(totalPrice)
                .build();
    }
}
