package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Ingredient;
import com.milunradonjic.recipes.repositories.IngredientRepository;
import com.milunradonjic.recipes.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Set<Ingredient> findAll() {
        log.debug("Request to get all Ingredients");
        return (Set<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        log.debug("Request to get Ingredient with id: {}", id);
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient with given id doesn't exist."));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        log.debug("Request to save Ingredient");
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        log.debug("Request to delete Ingredient");
        ingredientRepository.delete(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Ingredient with id: {}", id);
        ingredientRepository.deleteById(id);
    }
}
