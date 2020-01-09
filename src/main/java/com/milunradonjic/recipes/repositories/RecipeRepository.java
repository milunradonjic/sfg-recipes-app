package com.milunradonjic.recipes.repositories;

import com.milunradonjic.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
