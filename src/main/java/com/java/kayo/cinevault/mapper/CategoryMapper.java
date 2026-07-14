package com.java.kayo.cinevault.mapper;

import com.java.kayo.cinevault.Entity.Category;
import com.java.kayo.cinevault.request.CategoryRequest;
import com.java.kayo.cinevault.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {

        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {

        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
