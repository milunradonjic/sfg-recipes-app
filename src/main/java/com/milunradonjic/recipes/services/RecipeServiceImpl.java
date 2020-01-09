package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Recipe;
import com.milunradonjic.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> findAllRecipes() {
        log.debug("Request to get recipes");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findRecipeById(Long id) {
        log.debug("Request to get recipe by id: {}", id);
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe Not Found"));
    }
}
