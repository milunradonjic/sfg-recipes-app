package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> findAllRecipes();

    Recipe findRecipeById(Long id);
}
