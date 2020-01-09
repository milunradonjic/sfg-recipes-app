package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> findAll();

    Recipe findById(Long id);

    Recipe save(Recipe recipe);

    void delete(Recipe recipe);

    void deleteById(Long id);
}
