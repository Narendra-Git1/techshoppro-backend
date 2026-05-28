
package com.nari.techshoppro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Category;
import com.nari.techshoppro.exception.ResourceNotFoundException;
import com.nari.techshoppro.repository.CategoryRepository;
import com.nari.techshoppro.service.CategoryService;

@Service
public class CategoryServiceImpl
        implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(
            Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {

        return categoryRepository.findById(id)

                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category Not Found with ID: " + id
                        )
                );
    }

    @Override
    public Category updateCategory(
            Long id,
            Category category) {

        Category existingCategory =

                categoryRepository.findById(id)

                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category Not Found with ID: " + id
                                )
                        );

        existingCategory.setName(
                category.getName());

        existingCategory.setDescription(
                category.getDescription());

        return categoryRepository
                .save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {

        Category category =

                categoryRepository.findById(id)

                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category Not Found with ID: " + id
                                )
                        );

        categoryRepository.delete(category);
    }
}

