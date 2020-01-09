package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Category;
import com.milunradonjic.recipes.repositories.CategoryRepository;
import com.milunradonjic.recipes.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Set<Category> findAll() {
        log.debug("Request to get all Categories");
        return (Set<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        log.debug("Request to get Category with id: {}", id);
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with given id doesn't exist."));
    }

    @Override
    public Category save(Category category) {
        log.debug("Request to save Category");
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        log.debug("Request to delete Category");
        categoryRepository.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Category with id: {}", id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findByDescription(String description) {
        log.debug("Request to get Category by description");
        return categoryRepository.findByDescription(description).orElseThrow(() -> new RuntimeException("Category with given description doesn't exist."));
    }
}
