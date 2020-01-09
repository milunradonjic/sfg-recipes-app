package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Ingredient;
import com.milunradonjic.recipes.repositories.IngredientRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    final Long ID = 1L;

    IngredientServiceImpl ingredientService;

    @Mock
    IngredientRepository ingredientRepository;


    Ingredient ingredient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientRepository);
        ingredient = Ingredient.builder().id(ID).build();
    }

    @Test
    public void findAllIngredients() {
        Set<Ingredient> ingredientsData = new HashSet<>();
        ingredientsData.add(ingredient);

        when(ingredientRepository.findAll()).thenReturn(ingredientsData);

        Set<Ingredient> ingredients = ingredientService.findAll();
        assertEquals(ingredients.size(), 1);
        // verify that ingredientRepository is called only once
        verify(ingredientRepository, times(1)).findAll();
    }

    @Test
    public void findIngredientByIdFound() {
        Optional<Ingredient> optionalIngredient = Optional.ofNullable(ingredient);
        when(ingredientRepository.findById(anyLong())).thenReturn(optionalIngredient);
        Ingredient returnedIngredient = ingredientService.findById(ID);
        assertNotNull(returnedIngredient);
        assertEquals(ID, returnedIngredient.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findIngredientByIdNotFound() {
        Optional<Ingredient> optionalIngredient = Optional.empty();
        when(ingredientRepository.findById(anyLong())).thenReturn(optionalIngredient);
        ingredientService.findById(ID);
    }

    @Test
    public void save() {
        Ingredient ingredientToSave = Ingredient.builder().build();
        when(ingredientRepository.save(any())).thenReturn(ingredient);
        Ingredient savedIngredient = ingredientService.save(ingredientToSave);
        assertNotNull(savedIngredient);
        assertEquals(ID, savedIngredient.getId());
    }

    @Test
    public void delete() {
        ingredientService.delete(ingredient);
        verify(ingredientRepository).delete(any());
    }

    @Test
    public void deleteById() {
        ingredientService.deleteById(ID);
        verify(ingredientRepository).deleteById(anyLong());
    }

}