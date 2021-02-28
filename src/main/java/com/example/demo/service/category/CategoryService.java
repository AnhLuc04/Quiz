package com.example.demo.service.category;

import com.example.demo.model.category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findCategoryById(Long id);
    Category saveCategory(Category category);
    void removeCategory(Long id);

}
