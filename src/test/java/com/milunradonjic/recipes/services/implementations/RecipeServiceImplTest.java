package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Recipe;
import com.milunradonjic.recipes.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    final Long ID = 1L;

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;


    Recipe recipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
        recipe = Recipe.builder().id(ID).build();
    }

    @Test
    public void findAllRecipes() {
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.findAll();
        assertEquals(recipes.size(), 1);
        // verify that recipeRepository is called only once
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void findRecipeByIdFound() {
        Optional<Recipe> optionalRecipe = Optional.ofNullable(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);
        Recipe returnedRecipe = recipeService.findById(ID);
        assertNotNull(returnedRecipe);
        assertEquals(ID, returnedRecipe.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findRecipeByIdNotFound() {
        Optional<Recipe> optionalRecipe = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);
        recipeService.findById(ID);
    }

    @Test
    public void save() {
        Recipe recipeToSave = Recipe.builder().build();
        when(recipeRepository.save(any())).thenReturn(recipe);
        Recipe savedRecipe = recipeService.save(recipeToSave);
        assertNotNull(savedRecipe);
        assertEquals(ID, savedRecipe.getId());
    }

    @Test
    public void delete() {
        recipeService.delete(recipe);
        verify(recipeRepository).delete(any());
    }

    @Test
    public void deleteById() {
        recipeService.deleteById(ID);
        verify(recipeRepository).deleteById(anyLong());
    }
}