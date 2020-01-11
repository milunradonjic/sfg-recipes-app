package com.milunradonjic.recipes.mappers;

import com.milunradonjic.recipes.domain.Ingredient;
import com.milunradonjic.recipes.dtos.IngredientDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {RecipeMapper.class, UnitOfMeasureRecipe.class})
public interface IngredientMapper extends BaseMapper<IngredientDTO, Ingredient> {
}
