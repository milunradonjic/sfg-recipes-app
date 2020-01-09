package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Ingredient;

import java.util.Set;

public interface IngredientService {

    Set<Ingredient> findAll();

    Ingredient findById(Long id);

    Ingredient save(Ingredient ingredient);

    void delete(Ingredient ingredient);

    void deleteById(Long id);
}
