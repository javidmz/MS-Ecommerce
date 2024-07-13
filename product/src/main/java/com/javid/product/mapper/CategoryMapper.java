package com.javid.product.mapper;

import com.javid.product.entity.Category;
import com.javid.product.model.CategoryDTO;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
