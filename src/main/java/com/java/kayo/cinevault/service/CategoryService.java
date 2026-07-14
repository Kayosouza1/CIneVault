package com.java.kayo.cinevault.service;

import com.java.kayo.cinevault.Entity.Category;
import com.java.kayo.cinevault.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);
        if (savedCategory != null) {
            return categoryRepository.save(category);
        }
        return null;
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);

    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
