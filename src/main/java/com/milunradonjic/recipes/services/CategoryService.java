package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void delete(Category category);

    void deleteById(Long id);

    Category findByDescription(String description);
}
