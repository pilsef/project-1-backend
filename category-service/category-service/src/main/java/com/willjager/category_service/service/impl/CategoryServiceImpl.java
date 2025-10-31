package com.willjager.category_service.service.impl;

import com.willjager.category_service.entity.Category;
import com.willjager.category_service.repository.CategoryRepository;
import com.willjager.category_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
