package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Recipe;
import com.milunradonjic.recipes.repositories.RecipeRepository;
import com.milunradonjic.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> findAll() {
        log.debug("Request to get all Recipes");
        return (Set<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        log.debug("Request to get Recipe with id: {}", id);
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe with given id doesn't exist."));
    }

    @Override
    public Recipe save(Recipe recipe) {
        log.debug("Request to save Recipe");
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        log.debug("Request to delete Recipe");
        recipeRepository.delete(recipe);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Recipe with id: {}", id);
        recipeRepository.deleteById(id);
    }
}
